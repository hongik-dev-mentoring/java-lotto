package domain;

public class BonusBall {
	private final int bonusBallNumber;

	private BonusBall(int bonusBallNumber) {
		this.bonusBallNumber = bonusBallNumber;
	}

	public static BonusBall createBonusBallInRange(int startNumber, int endNumber, int bonusBallNumber) {
		validateBonusBallNumber(startNumber, endNumber, bonusBallNumber);
		return new BonusBall(bonusBallNumber);
	}

	private static void validateBonusBallNumber(int startNumber, int endNumber, int bonusBallNumber) {
		if (bonusBallNumber >= endNumber || bonusBallNumber < startNumber) {
			throw new IllegalArgumentException("[ERROR] 보너스 볼은 1부터 45까지의 숫자여야 합니다.");
		}
	}
}
