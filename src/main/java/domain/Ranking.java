package domain;

public enum Ranking {

	FIRST(2000000000), SECOND(30000000), THIRD(1500000),
	FOURTH(50000), FIFTH(5000), UNRANKED(0);

	private int winningAmount;

	Ranking(int winningAmount) {
		this.winningAmount = winningAmount;
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
