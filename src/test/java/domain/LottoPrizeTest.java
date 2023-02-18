package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {
    @ParameterizedTest
    @DisplayName("findLottoPrize 테스트")
    @CsvSource(value = {
            "3:false:PRIZE_5TH",
            "3:true:PRIZE_5TH",
            "4:true:PRIZE_4TH",
            "5:false:PRIZE_3RD",
            "5:true:PRIZE_2ND",
            "6:false:PRIZE_1ST"}, delimiter = ':')
    public void findLottoPrizeTest(int count, boolean hasBonus, LottoPrize expectedPrize) {
        LottoPrize actualPrize = LottoPrize.selectLottoPrize(count, hasBonus);
        assertThat(actualPrize).isEqualTo(expectedPrize);
    }

    @Test
    @DisplayName("getSortedLottoPrizes 테스트")
    public void getSortedLottoPrizesTest() {
        List<LottoPrize> lottoPrizes = LottoPrize.getSortedLottoPrizes();
        assertThat(lottoPrizes.contains(LottoPrize.NO_PRIZE)).isFalse();
    }
}
