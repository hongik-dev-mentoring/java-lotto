package domain;

import domain.numbers.WinningNumbers;

public class BonusBall {

	private final int bonusBallNumber;

	private BonusBall(int bonusBallNumber) {
		this.bonusBallNumber = bonusBallNumber;
	}

	public static BonusBall createBonusBallInRange(int startNumber, int endNumber, int bonusBallNumber, WinningNumbers winningNumbers) {
		validateBonusBallNumber(startNumber, endNumber, bonusBallNumber);
		validateDuplicateWithWinningNumber(bonusBallNumber, winningNumbers);
		return new BonusBall(bonusBallNumber);
	}

	private static void validateBonusBallNumber(int startNumber, int endNumber, int bonusBallNumber) {
		if (bonusBallNumber >= endNumber || bonusBallNumber < startNumber) {
			throw new IllegalArgumentException("[ERROR] 보너스 볼은 1부터 45까지의 숫자여야 합니다.");
		}
	}

	private static void validateDuplicateWithWinningNumber(int bonusBallNumber, WinningNumbers winningNumbers) {
		if (isContains(bonusBallNumber, winningNumbers)) {
			throw new IllegalArgumentException("[ERROR] 보너스 볼은 당첨 번호와 중복이 불가능합니다.");
		}
	}

	private static boolean isContains(int bonusBallNumber, WinningNumbers winningNumbers) {
		return winningNumbers.contains(bonusBallNumber);
	}

	public int getBonusBallNumber() {
		return bonusBallNumber;
	}
}
