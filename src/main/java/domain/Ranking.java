package domain;

public enum Ranking {

	FIRST, SECOND, THIRD, FOURTH, FIFTH, UNRANKED;

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
