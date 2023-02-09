package util.calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;

import org.junit.jupiter.api.Test;

import domain.Ranking;

class TotalPrizeCalculatorTest {

	@Test
	void 당첨_결과에_따라_총_상금을_계산할수_있다() {
		EnumMap<Ranking, Integer> lottoResult = new EnumMap<>(Ranking.class);
		lottoResult.put(Ranking.FIFTH, 5);

		long actualPrize = TotalPrizeCalculator.calculateTotalPrize(lottoResult);

		assertThat(actualPrize).isEqualTo(25000);
	}

}