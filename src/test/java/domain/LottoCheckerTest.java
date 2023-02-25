package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoCheckerTest {

    @Test
    @DisplayName("통계 결과 확인 테스트")
    void calculateLottoStatistics() {
        //given
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)));
        lottoNumbersList.add(new LottoNumbers(List.of(1, 2, 3, 4, 7, 8)));
        lottoNumbersList.add(new LottoNumbers(List.of(1, 2, 3, 4, 5, 8)));
        List<Integer> lastLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        //when
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        LottoChecker lottoChecker = new LottoChecker(lottoNumbersList, lottoWinningNumbers);
        Map<LottoPrize, Integer> resultMap = lottoChecker.calculateLottoStatistics();

        //then
        assertAll(
                () -> assertThat(resultMap.get(LottoPrize.PRIZE_1ST)).isEqualTo(1),
                () -> assertThat(resultMap.get(LottoPrize.PRIZE_2ND)).isEqualTo(1),
                () -> assertThat(resultMap.get(LottoPrize.PRIZE_3RD)).isEqualTo(1),
                () -> assertThat(resultMap.get(LottoPrize.PRIZE_4TH)).isEqualTo(0),
                () -> assertThat(resultMap.get(LottoPrize.PRIZE_5TH)).isEqualTo(0)
        );
    }
}
