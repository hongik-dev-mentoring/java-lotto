package domain;

import java.util.EnumMap;
import java.util.Map;

public class TotalPrizeCalculator {

	public static long calculateTotalPrize(EnumMap<Rank, Integer> resultRanking) {
		return resultRanking.entrySet()
			.stream()
			.map(TotalPrizeCalculator::calculatePrize)
			.reduce(0L, Long::sum);
	}

	private static long calculatePrize(Map.Entry<Rank, Integer> entry) {
		return (long) entry.getKey().getWinningAmount() * entry.getValue();
	}
}
