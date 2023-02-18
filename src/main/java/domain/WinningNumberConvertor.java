package domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumberConvertor {

	private static final String DELIMITER = ",";

	public static WinningNumbers convertWinningNumber(String winningNumber) {
		try {
			return new WinningNumbers(getWinningNumber(winningNumber));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다. 다시 입력해주세요");
		}
	}

	private static Set<LottoNumber> getWinningNumber(String winningNumber) {
		return Arrays.stream(winningNumber.split(DELIMITER))
			.map(String::trim)
			.map(Integer::parseInt)
			.map(LottoNumber::new)
			.collect(Collectors.toSet());
	}

	public static LottoNumber convertBonusNumber(String bonusNumber) {
		try {
			return new LottoNumber(Integer.parseInt(bonusNumber));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 한 개의 숫자여야 합니다. 다시 입력해주세요");
		}
	}
}
