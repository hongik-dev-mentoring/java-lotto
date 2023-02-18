package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static domain.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsCalculatorTest {
    @Test
    @DisplayName("통계 결과 확인 테스트")
    void calculateLottoStatistics() {
        // given
        List<LottoNumbers> lottoNumbersGroup = new ArrayList<>();
        lottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        lottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        lottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 8)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        lottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 7, 8, 9)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));

        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumbers lastLottoNumbers = new LottoNumbers(lottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        // when
        LottoStatisticsCalculator lottoStatisticsCalculator = new LottoStatisticsCalculator(lottoNumbersGroup, lottoWinningNumbers);
        EnumMap<LottoPrize, Integer> resultMap = lottoStatisticsCalculator.calculate();
        // then
        assertThat(resultMap.get(PRIZE_1ST)).isEqualTo(1);
        assertThat(resultMap.get(PRIZE_2ND)).isEqualTo(1);
        assertThat(resultMap.get(PRIZE_3RD)).isEqualTo(1);
        assertThat(resultMap.get(PRIZE_4TH)).isEqualTo(0);
        assertThat(resultMap.get(PRIZE_5TH)).isEqualTo(1);
    }
}