package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberCounterTest {
    private LottoNumberCounter lottoNumberCounter;

    @BeforeEach
    void setUpTest() {
        List<Integer> lastLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
    }

    @Test
    @DisplayName("당첨번호 카운트 테스트")
    void countLottoNumbersTest() {
        lottoNumberCounter.countLottoNumbers(1);
        lottoNumberCounter.countLottoNumbers(2);
        lottoNumberCounter.countLottoNumbers(3);
        lottoNumberCounter.countLottoNumbers(4);
        assertThat(lottoNumberCounter.decideLottoPrize()).isEqualTo("PRIZE_4TH");
    }

    @Test
    @DisplayName("보너스번호 카운트 테스트")
    void countBonusNumberTest() {
        lottoNumberCounter.countLottoNumbers(1);
        lottoNumberCounter.countLottoNumbers(2);
        lottoNumberCounter.countLottoNumbers(3);
        lottoNumberCounter.countLottoNumbers(4);
        lottoNumberCounter.countLottoNumbers(7);
        assertThat(lottoNumberCounter.decideLottoPrize()).isEqualTo("PRIZE_2ND");
    }

    @Test
    @DisplayName("로또 5등 당첨 테스트")
    void decideLottoPrizeTest() {
        lottoNumberCounter.countLottoNumbers(1);
        lottoNumberCounter.countLottoNumbers(2);
        lottoNumberCounter.countLottoNumbers(3);
        assertThat(lottoNumberCounter.decideLottoPrize()).isEqualTo("PRIZE_5TH");
    }
}