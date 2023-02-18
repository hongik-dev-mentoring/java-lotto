package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBenefitCalculatorTest {
    @Test
    @DisplayName("수익률 계산 테스트")
    public void calculateBenefitTest() {
        // given
        EnumMap<LottoPrize, Integer> resultMap = new EnumMap<>(LottoPrize.class);
        for (LottoPrize lottoPrize : LottoPrize.getSortedLottoPrizes()) {
            resultMap.put(lottoPrize, 1);
        }
        // when
        double benefit = LottoBenefitCalculator.calculate(14000, resultMap);
        // then
        assertThat(benefit).isEqualTo(145111.07);
    }
}
