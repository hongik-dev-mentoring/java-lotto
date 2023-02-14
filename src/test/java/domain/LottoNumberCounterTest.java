package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberCounterTest {
    private LottoNumberCounter lottoNumberCounter;
    private LottoWinningNumbers lottoWinningNumbers;

    @BeforeEach
    void setUpTest() {
        LastLottoNumbers lastLottoNumbers = new LastLottoNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");
        lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        lottoNumberCounter = new LottoNumberCounter();
    }

    @Test
    @DisplayName("당첨번호 카운트 테스트")
    void countLottoNumbersTest() {
        lottoNumberCounter.countLottoNumbers(lottoWinningNumbers, 1);
        lottoNumberCounter.countLottoNumbers(lottoWinningNumbers, 2);
        lottoNumberCounter.countLottoNumbers(lottoWinningNumbers, 3);
        Assertions.assertThat(lottoNumberCounter.getCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스번호 카운트 테스트")
    void countBonusNumberTest() {
        lottoNumberCounter.countLottoNumbers(lottoWinningNumbers, 1);
        lottoNumberCounter.countLottoNumbers(lottoWinningNumbers, 2);
        lottoNumberCounter.countLottoNumbers(lottoWinningNumbers, 3);
        lottoNumberCounter.countBonusNumber(lottoWinningNumbers, 7);
        Assertions.assertThat(lottoNumberCounter.getCount()).isEqualTo(4);
        Assertions.assertThat(lottoNumberCounter.hasBonusNumber()).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 5등 당첨 시 LottoConstant.FIFTH_PRIZE_KEY 반환 테스트")
    void decideLottoPrize() {
        //given
        lottoNumberCounter.countLottoNumbers(lottoWinningNumbers, 1);
        lottoNumberCounter.countLottoNumbers(lottoWinningNumbers, 2);
        lottoNumberCounter.countLottoNumbers(lottoWinningNumbers, 3);
        //when
        Assertions.assertThat(lottoNumberCounter.decideLottoPrize()).isEqualTo("PRIZE_5TH");
    }
}