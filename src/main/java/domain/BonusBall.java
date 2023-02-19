package domain;

import domain.numbers.Numbers;

public class BonusBall {

	private final int bonusBallNumber;

	public BonusBall(int bonusBallNumber) {
		this.bonusBallNumber = bonusBallNumber;
	}

	public static BonusBall createBonusBallInRange(LottoNumberRange lottoNumberRange, int bonusBallNumber, Numbers winningNumbers) {
		validateBonusBallNumber(lottoNumberRange, bonusBallNumber);
		validateDuplicateWithWinningNumber(bonusBallNumber, winningNumbers);
		return new BonusBall(bonusBallNumber);
	}

	private static void validateBonusBallNumber(LottoNumberRange lottoNumberRange, int bonusBallNumber) {
		if (!lottoNumberRange.checkInRanged(bonusBallNumber)) {
			throw new IllegalArgumentException("[ERROR] 보너스 볼은 1부터 45까지의 숫자여야 합니다.");
		}
	}

	private static void validateDuplicateWithWinningNumber(int bonusBallNumber, Numbers winningNumbers) {
		if (isContains(bonusBallNumber, winningNumbers)) {
			throw new IllegalArgumentException("[ERROR] 보너스 볼은 당첨 번호와 중복이 불가능합니다.");
		}
	}

	private static boolean isContains(int bonusBallNumber, Numbers winningNumbers) {
		return winningNumbers.contains(bonusBallNumber);
	}

	public int getBonusBallNumber() {
		return bonusBallNumber;
	}
}
