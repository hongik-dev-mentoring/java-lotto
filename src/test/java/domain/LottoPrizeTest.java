package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPrizeTest {
    @ParameterizedTest
    @DisplayName("findLottoPrize 테스트")
    @CsvSource(value = {
            "3:false:PRIZE_5TH",
            "5:false:PRIZE_3RD",
            "5:true:PRIZE_2ND",
            "6:false:PRIZE_1ST"}, delimiter = ':')
    public void findLottoPrizeTest(int count, boolean hasBonus, LottoPrize expectedPrize) {
        LottoPrize actualPrize = LottoPrize.selectLottoPrize(count, hasBonus);
        Assertions.assertThat(actualPrize).isEqualTo(expectedPrize);
    }
}
