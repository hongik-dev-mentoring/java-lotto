package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.EnumMap;

import org.junit.jupiter.api.Test;

class LottoTest {

	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 7;
	private static final int PICK_NUMBERS = 6;
	private static final int LOTTO_NUMBERS = 10;

	@Test
	void 임의_갯수의_로또_번호를_가진_로또_객체를_만들_수_있다() {
		RandomNumberPicker randomNumberPicker = new RandomNumberPicker(START_NUMBER, END_NUMBER, PICK_NUMBERS);
		Lotto lotto = Lotto.generateLottoWithLottoNumbers(randomNumberPicker, LOTTO_NUMBERS);
		assertThat(lotto.getLottoNumbers().getNumbers().size()).isEqualTo(10);
	}

	@Test
	void 로또_번호를_입력하면_당첨_결과를_받을_수_있다() {
		RandomNumberPicker randomNumberPicker = new RandomNumberPicker(START_NUMBER, END_NUMBER, PICK_NUMBERS);
		Lotto lotto = Lotto.generateLottoWithLottoNumbers(randomNumberPicker, LOTTO_NUMBERS);
		Numbers numbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		Integer bonusBall = 7;

		EnumMap<Ranking, Integer> lottoRanking = lotto.checkLottoResult(numbers, bonusBall);
		Integer actualWinnerNumber = lottoRanking.get(Ranking.FIRST);

		assertThat(actualWinnerNumber).isEqualTo(LOTTO_NUMBERS);
	}
}
