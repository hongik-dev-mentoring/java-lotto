package domain;

import java.util.Arrays;

public enum Ranking {

	FIRST(6, 2_000_000_000), SECOND(5, 30_000_000), THIRD(5, 1_500_000),
	FOURTH(4, 50_000), FIFTH(3, 5_000), UNRANKED(0, 0);

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
