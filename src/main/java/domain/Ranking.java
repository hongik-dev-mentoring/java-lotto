package domain;

import java.util.Arrays;

public enum Ranking {

	FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5, 1500000),
	FOURTH(4, 50000), FIFTH(3, 5000), UNRANKED(0, 0);

	private final int correctNumber;
	private final int winningAmount;

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
		return Arrays.stream(Ranking.values())
			.filter(ranking -> ranking.correctNumber == correctNumber)
			.findAny()
			.orElse(UNRANKED);
	}
}
