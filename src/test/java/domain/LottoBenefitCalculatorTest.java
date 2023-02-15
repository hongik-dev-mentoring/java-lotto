package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBenefitCalculatorTest {
    @Test
    @DisplayName("수익률 계산 테스트")
    public void calculateBenefitTest() {
        // given
        Map<LottoPrize, Integer> resultMap = new HashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.getSortedLottoPrizes()) {
            resultMap.put(lottoPrize, 1);
        }
        // when
        double benefit = LottoBenefitCalculator.calculate(14000, resultMap);
        // then
        assertThat(benefit).isEqualTo(145111.07);
    }
}
