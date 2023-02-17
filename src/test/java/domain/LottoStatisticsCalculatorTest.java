package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static domain.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsCalculatorTest {
    @Test
    @DisplayName("통계 결과 확인 테스트")
    void calculateLottoStatistics() {
        // given
        List<LottoDto> lottoDtos = new ArrayList<>();
        lottoDtos.add(new LottoDto(List.of(1, 2, 3, 4, 5, 6)));
        lottoDtos.add(new LottoDto(List.of(1, 2, 3, 4, 5, 7)));
        lottoDtos.add(new LottoDto(List.of(1, 2, 3, 4, 5, 8)));

        List<Integer> lastLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        // when
        LottoStatisticsCalculator lottoStatisticsCalculator = new LottoStatisticsCalculator(lottoDtos, lottoWinningNumbers);
        Map<LottoPrize, Integer> resultMap = lottoStatisticsCalculator.calculate();
        // then
        assertThat(resultMap.get(PRIZE_1ST)).isEqualTo(1);
        assertThat(resultMap.get(PRIZE_2ND)).isEqualTo(1);
        assertThat(resultMap.get(PRIZE_3RD)).isEqualTo(1);
        assertThat(resultMap.get(PRIZE_4TH)).isEqualTo(0);
        assertThat(resultMap.get(PRIZE_5TH)).isEqualTo(0);
    }
}