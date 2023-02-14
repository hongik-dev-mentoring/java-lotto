package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoTest {

	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 7;
	private static final int PICK_NUMBERS = 6;
	private static final int LOTTO_NUMBERS = 10;
	private static final int BONUS_NUMBER = 7;

	@Test
	void 임의_갯수의_로또_번호를_가진_로또_객체를_만들_수_있다() {
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(START_NUMBER, END_NUMBER, PICK_NUMBERS);
		Lotto lotto = Lotto.generateLottoWithLottoNumbers(lottoNumberGenerator, LOTTO_NUMBERS);
		assertThat(lotto.getLottoTicketNumbers().getLottoTicket().size()).isEqualTo(10);
	}
}
