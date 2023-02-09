package convertor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.LottoNumbers;

public class LottoNumberConvertor {
	private static final String DELIMITER = ",";
	private static final int LOTTO_NUMBER = 6;

	public static LottoNumbers convertWinningNumber(String winningNumber) {
		try {
			String[] split = winningNumber.split(DELIMITER);
			List<Integer> winnerNumbers = Arrays.stream(split)
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList());

			validateWinningNumber(winnerNumbers);
			return new LottoNumbers(winnerNumbers);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다. 다시 입력해주세요");
		}
	}

	private static void validateWinningNumber(List<Integer> winnerNumbers) {
		if (winnerNumbers.size() != LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 여섯개여야 합니다.");
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
