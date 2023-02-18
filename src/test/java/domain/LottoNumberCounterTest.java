package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static domain.LottoPrize.PRIZE_2ND;
import static domain.LottoPrize.PRIZE_4TH;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberCounterTest {
    private LottoNumberCounter lottoNumberCounter;

    @BeforeEach
    public void init() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbers lastLottoNumbers = new LottoNumbers(lottoNumbers);
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
    }

    @Test
    @DisplayName("당첨번호 카운트 테스트")
    public void countLottoNumbersTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 10, 11)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumbers lottoTicket = new LottoNumbers(lottoNumbers);
        // when & then
        assertThat(lottoNumberCounter.decideLottoPrize(lottoTicket))
                .isEqualTo(PRIZE_4TH);
    }

    @Test
    @DisplayName("보너스번호 카운트 테스트")
    public void countBonusNumberTest() {
        // given
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumbers lottoTicket = new LottoNumbers(lottoNumbers);
        // when & then
        assertThat(lottoNumberCounter.decideLottoPrize(lottoTicket))
                .isEqualTo(PRIZE_2ND);
    }
}