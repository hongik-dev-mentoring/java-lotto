package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCheckerTest {
    @Test
    @DisplayName("통계 결과 확인 테스트")
    void calculateLottoStatistics() {
        // given
        List<LottoDto> lottoDtoGroup = new ArrayList<>();
        lottoDtoGroup.add(new LottoDto(List.of(1, 2, 3, 4, 5, 6)));
        lottoDtoGroup.add(new LottoDto(List.of(1, 2, 3, 4, 7, 8)));
        lottoDtoGroup.add(new LottoDto(List.of(1, 2, 3, 4, 5, 8)));

        LastLottoNumbers lastLottoNumbers = new LastLottoNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        // when
        LottoChecker lottoChecker = new LottoChecker(lottoDtoGroup, lottoWinningNumbers);
        Map<String, Integer> resultMap = lottoChecker.calculateLottoStatistics();
        // then
        assertThat(resultMap.get("PRIZE_1ST")).isEqualTo(1);
        assertThat(resultMap.get("PRIZE_2ND")).isEqualTo(1);
        assertThat(resultMap.get("PRIZE_3RD")).isEqualTo(1);
        assertThat(resultMap.get("PRIZE_4TH")).isEqualTo(0);
        assertThat(resultMap.get("PRIZE_5TH")).isEqualTo(0);
    }
}