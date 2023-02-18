package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import java.util.EnumMap;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class TotalPrizeCalculatorTest {

	@Test
	void 랭킹에_따른_당첨금을_계산할_수_있다() {
		EnumMap<Rank, Integer> enumMap = new EnumMap<>(Rank.class);
		enumMap.put(Rank.FIFTH, 5);

		long totalPrize = TotalPrizeCalculator.calculateTotalPrize(enumMap);

		assertThat(totalPrize).isEqualTo(25000);
	}
}