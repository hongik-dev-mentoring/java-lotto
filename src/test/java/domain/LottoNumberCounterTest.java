package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoNumberCounterTest {

    private LottoNumberCounter lottoNumberCounter;

    @BeforeEach
    void setUp() {
        List<Integer> lastLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
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
        Assertions.assertThat(lottoNumberCounter.getCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스번호 카운트 테스트")
    void countBonusNumberTest() {
        lottoNumberCounter.countLottoNumbers(1);
        lottoNumberCounter.countLottoNumbers(2);
        lottoNumberCounter.countLottoNumbers(3);
        lottoNumberCounter.countBonusNumber(7);
        Assertions.assertThat(lottoNumberCounter.getCount()).isEqualTo(4);
        Assertions.assertThat(lottoNumberCounter.hasBonusNumber()).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 5등 당첨 시 LottoConstant.FIFTH_PRIZE_KEY 반환 테스트")
    void decideLottoPrize() {
        //given
        lottoNumberCounter.countLottoNumbers(1);
        lottoNumberCounter.countLottoNumbers(3);
        lottoNumberCounter.countLottoNumbers(2);
        //when
        Assertions.assertThat(lottoNumberCounter.decideLottoPrize()).isEqualTo(LottoConstant.FIFTH_PRIZE_KEY);
    }
}
