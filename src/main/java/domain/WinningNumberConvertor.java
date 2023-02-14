package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberConvertor {

	private static final String DELIMITER = ",";

	public static WinningNumbers convertWinningNumber(String winningNumber) {
		try {
			String[] split = winningNumber.split(DELIMITER);
			List<Integer> winnerNumbers = Arrays.stream(split)
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList());

			return new WinningNumbers(winnerNumbers);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다. 다시 입력해주세요");
		}
	}

	public static Integer convertBonusNumber(String bonusNumber) {
		try {
			return Integer.parseInt(bonusNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 한 개의 숫자여야 합니다. 다시 입력해주세요");
		}
	}
}
