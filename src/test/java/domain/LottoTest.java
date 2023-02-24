package domain;

import static org.assertj.core.api.Assertions.*;

import domain.numbers.LottoNumberGenerator;
import domain.numbers.LottoNumber;
import domain.numbers.WinningNumber;
import java.util.ArrayList;
import java.util.EnumMap;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

	private static final int LOTTO_COUNT = 1;
	private static final LottoTicket emptyManualLottoTicket = new LottoTicket(new ArrayList<>());

	LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
	Lotto lotto = Lotto.generateLottoWithManualLottoTicket(lottoNumberGenerator, LOTTO_COUNT,
		emptyManualLottoTicket);

	@Test
	void 임의_갯수의_로또_번호를_가진_로또_객체를_만들_수_있다() {
		Lotto lotto = Lotto.generateLottoWithManualLottoTicket(lottoNumberGenerator, LOTTO_COUNT,
			emptyManualLottoTicket);
		assertThat(lotto.getLottoTicket().getLottoNumbers().size()).isEqualTo(LOTTO_COUNT);
	}

	@Test
	void 임의로_번호를_입력하면_당첨_결과를_받을_수_있다() {
		Lotto lotto = Lotto.generateLottoWithManualLottoTicket(lottoNumberGenerator, LOTTO_COUNT,
			emptyManualLottoTicket);
		LottoNumber lottoNumber = lotto.getLottoTicket().getLottoNumbers().get(0);
		WinningNumber winningNumber = new WinningNumber(
			lottoNumber, getRandomNumberNotDuplicate(lottoNumber.getNumbers()));

		EnumMap<Ranking, Integer> lottoRanking = lotto.checkLottoResult(winningNumber);
		Integer actualWinnerNumber = lottoRanking.get(Ranking.FIRST);

		assertThat(actualWinnerNumber).isEqualTo(LOTTO_COUNT);
	}

	@Test
	void 다섯개의_번호와_보너스볼이_일치하면_2등에_당첨된다() {
		List<Integer> anyLottoNumbers = lotto.getLottoTicket().getLottoNumbers().get(0).getNumbers();

		List<Integer> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(getRandomNumberNotDuplicate(anyLottoNumbers));
		lottoNumbers.addAll(anyLottoNumbers);

		List<Integer> secondPrizeNumbers = List.copyOf(lottoNumbers.subList(0, lottoNumbers.size() - 1));
		LottoNumber secondPrizeLottoNumber = new LottoNumber(secondPrizeNumbers);
		int bonusBallNumber = lottoNumbers.get(lottoNumbers.size() - 1);

		WinningNumber winningNumber = new WinningNumber(secondPrizeLottoNumber, bonusBallNumber);
		EnumMap<Ranking, Integer> lottoRanking = lotto.checkLottoResult(winningNumber);
		Integer actualWinnerNumber = lottoRanking.get(Ranking.SECOND);

		assertThat(actualWinnerNumber).isEqualTo(LOTTO_COUNT);
	}

	@Test
	void 다섯개의_번호가_일치하고_보너스볼이_불일치하면_3등에_당첨된다() {
		List<Integer> anyLottoNumbers = lotto.getLottoTicket().getLottoNumbers().get(0).getNumbers();

		List<Integer> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(getRandomNumberNotDuplicate(anyLottoNumbers));
		lottoNumbers.add(getRandomNumberNotDuplicate(anyLottoNumbers));
		lottoNumbers.addAll(anyLottoNumbers);

		List<Integer> secondPrizeNumbers = List.copyOf(lottoNumbers.subList(1, lottoNumbers.size() - 1));
		LottoNumber secondPrizeLottoNumber = new LottoNumber(secondPrizeNumbers);
		int bonusBallNumber = lottoNumbers.get(0);

		WinningNumber winningNumber = new WinningNumber(secondPrizeLottoNumber, bonusBallNumber);
		EnumMap<Ranking, Integer> lottoRanking = lotto.checkLottoResult(winningNumber);
		Integer actualWinnerNumber = lottoRanking.get(Ranking.THIRD);

		assertThat(actualWinnerNumber).isEqualTo(LOTTO_COUNT);
	}

	Integer getRandomNumberNotDuplicate(List<Integer> numbers) {
		int bonusBallNumber = numbers.get(0);
		while (numbers.contains(bonusBallNumber)) {
			double randomValue = Math.random();
			bonusBallNumber = (int) (randomValue * 45) + 1;
		}
		System.out.println(bonusBallNumber);
		return bonusBallNumber;
	}
}
