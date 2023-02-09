package domain;

public enum Ranking {

	FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5, 1500000),
	FOURTH(4, 50000), FIFTH(3, 5000), UNRANKED(0, 0);

	private int correctNumber;
	private int winningAmount;

	Ranking(int correctNumber, int winningAmount) {
		this.correctNumber = correctNumber;
		this.winningAmount = winningAmount;
	}

	public int getCorrectNumber() {
		return correctNumber;
	}

	public int getWinningAmount() {
		return winningAmount;
	}

	public static Ranking getRanking(int correctNumber) {
		if (correctNumber < 3) {
			return UNRANKED;
		}

		if (correctNumber == 3) {
			return FIFTH;
		}

		if (correctNumber == 4) {
			return FOURTH;
		}

		if (correctNumber == 6) {
			return FIRST;
		}
		return THIRD;
	}
}
