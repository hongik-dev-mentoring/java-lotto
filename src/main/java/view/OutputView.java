package view;

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

	private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
	private static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n---------";

	public static void printLottoTicket(LottoTicketDto lottoTicketDto) {
		lottoTicketDto.getLottoNumbersDto()
			.stream()
			.forEach(System.out::println);
	}

	public static void printLottoPurchaseCount(int purchaseCount) {
		StringBuilder purchaseCountString = new StringBuilder()
			.append(purchaseCount)
			.append(PURCHASE_MESSAGE);
		System.out.println(purchaseCountString);
	}

	public static void printLottoResult(LottoResultDto lottoResultDto) {
		System.out.println(LOTTO_RESULT_MESSAGE);
		List<Ranking> rankings = Arrays.stream(Ranking.values())
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

		if (winningAmount == 30000000) {
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
}
