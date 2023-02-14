package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static domain.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberCounterTest {
    private LottoNumberCounter lottoNumberCounter;

    @BeforeEach
    void initTest() {
        List<Integer> lastLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
    }

    @Test
    @DisplayName("당첨번호 카운트 테스트")
    void countLottoNumbersTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 10, 11);
        assertThat(lottoNumberCounter.decideLottoPrize(new LottoDto(lottoNumbers)))
                .isEqualTo(PRIZE_4TH);
    }

    @Test
    @DisplayName("보너스번호 카운트 테스트")
    void countBonusNumberTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        assertThat(lottoNumberCounter.decideLottoPrize(new LottoDto(lottoNumbers)))
                .isEqualTo(PRIZE_2ND);
    }
}