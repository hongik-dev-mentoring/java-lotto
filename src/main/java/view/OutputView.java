package view;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dto.LottoNumberDto;
import dto.LottoNumbersDto;
import dto.LottoResultDto;
import dto.LottoTicketDto;
import dto.RankDto;

public class OutputView {

	private static final String LOTTO_RESULT_HEADER_MESSAGE = "당첨 통계";
	private static final String DIVIDING_LINE = "---------";
	private static final String DELIMITER = ", ";
	private static final double SECOND_DECIMAL_PLACE = 100.0;

	public static void printLottoTicket(LottoTicketDto lottoTicketDto, int manualLottoCount, int autoLottoCount) {
		StringBuilder stringBuilder = new StringBuilder();
		appendLottoTicketHeader(stringBuilder, manualLottoCount, autoLottoCount);
		appendLottoTicketBody(stringBuilder, lottoTicketDto);
		System.out.println(stringBuilder);
	}

	private static void appendLottoTicketHeader(StringBuilder stringBuilder, int manualLottoCount, int autoLottoCount) {
		stringBuilder.append("수동으로 ")
			.append(manualLottoCount)
			.append("장, ")
			.append("자동으로 ")
			.append(autoLottoCount)
			.append("개를 ")
			.append("구매했습니다.")
			.append(System.lineSeparator());
	}

	private static void appendLottoTicketBody(StringBuilder stringBuilder, LottoTicketDto lottoTicketDto) {
		for (LottoNumbersDto numbersDto : lottoTicketDto.getLottoNumbersDto()) {
			List<LottoNumberDto> lottoNumbers = numbersDto.getNumbers();
			stringBuilder.append("[")
				.append(String.join(DELIMITER, getLottoNumbers(lottoNumbers)))
				.append("]")
				.append(System.lineSeparator());
		}
	}

	private static List<String> getLottoNumbers(List<LottoNumberDto> lottoNumbers) {
		return lottoNumbers.stream()
			.map(LottoNumberDto::getLottoNumber)
			.map(String::valueOf)
			.collect(Collectors.toList());
	}

	public static void printLottoResult(LottoResultDto lottoResultDto, double profit) {
		StringBuilder stringBuilder = new StringBuilder();
		appendLottoResultHeader(stringBuilder);
		appendLottoResultBody(stringBuilder, lottoResultDto);
		appendProfitRate(stringBuilder, profit);
		System.out.println(stringBuilder);
	}

	private static void appendLottoResultHeader(StringBuilder stringBuilder) {
		stringBuilder.append(System.lineSeparator())
			.append(LOTTO_RESULT_HEADER_MESSAGE)
			.append(System.lineSeparator())
			.append(DIVIDING_LINE)
			.append(System.lineSeparator());
	}

	private static void appendLottoResultBody(StringBuilder stringBuilder, LottoResultDto lottoResultDto) {
		EnumMap<RankDto, Integer> lottoResult = lottoResultDto.getLottoResult();

		for (RankDto rankDto : RankDto.getRankDtos()) {
			stringBuilder.append(rankDto.getCorrectNumber())
				.append("개 일치")
				.append(getBonus(rankDto));
			stringBuilder.append("(")
				.append(rankDto.getWinningAmount()).append("원) - ")
				.append(getCount(lottoResult, rankDto))
				.append("개")
				.append(System.lineSeparator());
		}
	}

	private static String getBonus(RankDto rankDto) {
		if (rankDto.isBonus()) {
			return ", 보너스 볼 일치";
		}
		return " ";
	}

	private static int getCount(EnumMap<RankDto, Integer> lottoResult, RankDto rankDto) {
		return Optional.ofNullable(lottoResult.get(rankDto)).orElse(0);
	}

	private static void appendProfitRate(StringBuilder stringBuilder, double profitRate) {
		stringBuilder.append("총 수익률은 ")
			.append(Math.floor(profitRate * SECOND_DECIMAL_PLACE) / SECOND_DECIMAL_PLACE)
			.append("입니다.");
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	public static void printBlankLine() {
		System.out.println();
	}
}
