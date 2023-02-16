package domain;

public class BonusBall {

	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private final int bonusBallNumber;

	private BonusBall(int bonusBallNumber) {
		this.bonusBallNumber = bonusBallNumber;
	}

	public static BonusBall createBonusBallInRange(int bonusBallNumber, WinningNumbers winningNumbers) {
		validateBonusBallNumber(bonusBallNumber);
		validateDuplicateWithWinningNumber(bonusBallNumber, winningNumbers);
		return new BonusBall(bonusBallNumber);
	}

	private static void validateBonusBallNumber(int bonusBallNumber) {
		if (bonusBallNumber > MAX_LOTTO_NUMBER || bonusBallNumber < MIN_LOTTO_NUMBER) {
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
