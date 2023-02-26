package view;

import dto.LottoNumbersDto;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import domain.Ranking;
import dto.LottoResultDto;
import dto.LottoTicketDto;

public class OutputView {

	private static final String MANUAL_LOTTO_PURCHASE_MESSAGE = "수동으로 ";
	private static final String MANUAL_LOTTO_PURCHASE_COUNT_MESSAGE = "장, ";
	private static final String AUTO_LOTTO_PURCHASE_MESSAGE = "자동으로 ";
	private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
	private static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n---------";

	public static void printLottoTicket(LottoTicketDto lottoTicketDto) {
		lottoTicketDto.getLottoNumbersDto()
			.forEach(OutputView::printLottoNumbers);
	}

	public static void printLottoPurchaseCount(int purchaseCount, int manualLottoPurchaseCount) {
		StringBuilder purchaseCountString = new StringBuilder(MANUAL_LOTTO_PURCHASE_MESSAGE)
			.append(manualLottoPurchaseCount)
			.append(MANUAL_LOTTO_PURCHASE_COUNT_MESSAGE)
			.append(AUTO_LOTTO_PURCHASE_MESSAGE)
			.append(purchaseCount)
			.append(PURCHASE_MESSAGE);
		System.out.println(purchaseCountString);
	}

	public static void printLottoResult(LottoResultDto lottoResultDto) {
		System.out.println(LOTTO_RESULT_MESSAGE);
		Ranking[] rankingValues = Ranking.values();
		List<Ranking> rankings = Arrays.stream(rankingValues)
			.filter(ranking -> ranking != Ranking.UNRANKED)
			.sorted(Collections.reverseOrder())
			.collect(Collectors.toList());
		EnumMap<Ranking, Integer> rankingResults = lottoResultDto.getLottoResult();
		rankings.forEach(ranking ->
			buildLottoResultMessage(ranking.getCorrectNumber(),
				ranking.getWinningAmount(), Optional.ofNullable(rankingResults.get(ranking)).orElse(0))
		);
	}

	private static void buildLottoResultMessage(int correctNumber, int winningAmount, int resultCount) {
		StringBuilder lottoResultMessage = new StringBuilder()
			.append(correctNumber)
			.append("개 일치 ");

		if (winningAmount == Ranking.SECOND.getWinningAmount()) {
			lottoResultMessage.setLength(lottoResultMessage.length() - 1);
			lottoResultMessage.append(", 보너스 볼 일치");
		}

		lottoResultMessage.append("(")
			.append(winningAmount)
			.append("원) - ")
			.append(resultCount)
			.append("개");
		System.out.println(lottoResultMessage);
	}

	public static void printProfitRate(double profitRate) {
		System.out.print("총 수익률 ");
		System.out.printf("%.2f", profitRate);
		System.out.println("입니다.");
	}

	public static void printBlankLine() {
		System.out.println();
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	private static void printLottoNumbers(LottoNumbersDto lottoNumbersDto) {
		System.out.println(lottoNumbersDto.getLottoNumbers());
	}
}
