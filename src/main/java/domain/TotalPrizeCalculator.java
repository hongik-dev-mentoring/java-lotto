package domain;

import java.util.EnumMap;
import java.util.Map;

public class TotalPrizeCalculator {

	public static long calculateTotalPrize(EnumMap<Ranking, Integer> resultRanking) {
		return resultRanking.entrySet()
			.stream()
			.map(TotalPrizeCalculator::calculatePrize)
			.reduce(0L, Long::sum);
	}

	private static long calculatePrize(Map.Entry<Ranking, Integer> entry) {
		return (long) entry.getKey().getWinningAmount() * entry.getValue();
	}
}
