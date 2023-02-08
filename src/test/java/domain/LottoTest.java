package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoTest {
	private static final int LOTTO_NUMBERS = 10;

	@Test
	void 임의_갯수의_로또_번호를_가진_로또_객체를_만들_수_있다() {
		Lotto lotto = Lotto.generateLottoWithLottoNumbers(LOTTO_NUMBERS);
		assertThat(lotto.getLottoNumbers().getLottoNumbers().size()).isEqualTo(10);
	}
}
