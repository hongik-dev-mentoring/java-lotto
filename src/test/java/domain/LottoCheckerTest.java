package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LottoCheckerTest {
    @Test
    @DisplayName("통계 결과 확인 테스트")
    void calculateLottoStatistics() {
        // given
        List<LottoDto> lottoDtoList = new ArrayList<>();
        lottoDtoList.add(new LottoDto(List.of(1, 2, 3, 4, 5, 6)));
        lottoDtoList.add(new LottoDto(List.of(1, 2, 3, 4, 7, 8)));
        lottoDtoList.add(new LottoDto(List.of(1, 2, 3, 4, 5, 8)));

        LastLottoNumbers lastLottoNumbers = new LastLottoNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        // when
        LottoChecker lottoChecker = new LottoChecker(lottoDtoList, lottoWinningNumbers);
        Map<String, Integer> resultMap = lottoChecker.calculateLottoStatistics();
        // then
        Assertions.assertThat(resultMap.get("FIRST_PRIZE")).isEqualTo(1);
        Assertions.assertThat(resultMap.get("SECOND_PRIZE")).isEqualTo(1);
        Assertions.assertThat(resultMap.get("THIRD_PRIZE")).isEqualTo(1);
        Assertions.assertThat(resultMap.get("FOURTH_PRIZE")).isEqualTo(0);
        Assertions.assertThat(resultMap.get("FIFTH_PRIZE")).isEqualTo(0);
    }
}