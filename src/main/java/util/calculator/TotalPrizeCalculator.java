package util.calculator;

import java.util.EnumMap;
import java.util.Map;

import domain.Ranking;

public class TotalPrizeCalculator {

	public static long calculateTotalPrize(EnumMap<Ranking, Integer> resultRanking) {
		return resultRanking.entrySet()
			.stream()
			.map(TotalPrizeCalculator::calculateRankingPrize)
			.reduce(0L, Long::sum);
	}


	private static long calculateRankingPrize(Map.Entry<Ranking, Integer> entry) {
		return (long) entry.getKey().getWinningAmount() * entry.getValue();
	}
}
