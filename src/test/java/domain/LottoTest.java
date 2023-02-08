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
	private static final int BONUS_NUMBER = 7;

	@Test
	void 임의_갯수의_로또_번호를_가진_로또_객체를_만들_수_있다() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(START_NUMBER, END_NUMBER, PICK_NUMBERS);
		Lotto lotto = Lotto.generateLottoWithLottoNumbers(randomNumberGenerator, LOTTO_NUMBERS);
		assertThat(lotto.getLottoNumbers().getNumbers().size()).isEqualTo(10);
	}

	@Test
	void 임의로_번호를_입력하면_당첨_결과를_받을_수_있다() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(START_NUMBER, END_NUMBER, PICK_NUMBERS);
		Lotto lotto = Lotto.generateLottoWithLottoNumbers(randomNumberGenerator, LOTTO_NUMBERS);
		Numbers pickNumbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		Integer bonusBall = BONUS_NUMBER;

		EnumMap<Ranking, Integer> lottoRanking = lotto.checkLottoResult(pickNumbers, bonusBall);
		Integer actualWinnerNumber = lottoRanking.get(Ranking.FIRST);

		assertThat(actualWinnerNumber).isEqualTo(LOTTO_NUMBERS);
	}

	@Test
	void 다섯개의_번호와_보너스볼이_일치하면_2등에_당첨된다() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(START_NUMBER + 1, END_NUMBER + 1, PICK_NUMBERS);
		Lotto lotto = Lotto.generateLottoWithLottoNumbers(randomNumberGenerator, LOTTO_NUMBERS);
		Numbers pickNumbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));

		EnumMap<Ranking, Integer> lottoRanking = lotto.checkLottoResult(pickNumbers, BONUS_NUMBER);
		Integer actualWinnerNumber = lottoRanking.get(Ranking.SECOND);

		assertThat(actualWinnerNumber).isEqualTo(LOTTO_NUMBERS);
	}

	@Test
	void 다섯개의_번호가_일치하고_보너스볼이_불일치하면_3등에_당첨된다() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(START_NUMBER + 1, END_NUMBER + 1, PICK_NUMBERS);
		Lotto lotto = Lotto.generateLottoWithLottoNumbers(randomNumberGenerator, LOTTO_NUMBERS);
		Numbers pickNumbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));

		EnumMap<Ranking, Integer> lottoRanking = lotto.checkLottoResult(pickNumbers, 10);
		Integer actualWinnerNumber = lottoRanking.get(Ranking.THIRD);

		assertThat(actualWinnerNumber).isEqualTo(LOTTO_NUMBERS);
	}
}
