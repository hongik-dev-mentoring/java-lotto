package convertor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Numbers;

public class LottoNumberConvertor {
	private static final String DELIMITER = ",";

	public static Numbers convertWinningNumber(String winningNumber) {
		String[] split = winningNumber.split(DELIMITER);
		List<Integer> winnerNumbers = Arrays.stream(split)
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		return new Numbers(winnerNumbers);
	}
}
