package domain;

import static org.assertj.core.api.Assertions.*;

import domain.numbers.LottoNumbers;
import domain.numbers.Numbers;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 46;
	private static final int PICK_NUMBERS = 6;

	@Test
	void 범위내의_숫자를_뽑을수_있다() {
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(START_NUMBER, END_NUMBER, PICK_NUMBERS);

		Numbers lottoNumbers = lottoNumberGenerator.pickNumber();
		List<Integer> actualNumbers = lottoNumbers.getNumbers();

		List<Integer> expectedNumbers = List.copyOf(actualNumbers);
		List<Integer> afterFilteringNumbers = actualNumbers.stream()
			.filter(i -> i < END_NUMBER)
			.filter(i -> i >= START_NUMBER)
			.collect(Collectors.toList());

		assertThat(afterFilteringNumbers).isEqualTo(expectedNumbers);
	}

	@Test
	void 임의_갯수의_숫자를_뽑을_수_있다() {
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(START_NUMBER, END_NUMBER, PICK_NUMBERS);

		Numbers lottoNumbers = lottoNumberGenerator.pickNumber();
		List<Integer> pickedNumbers = lottoNumbers.getNumbers();

		assertThat(pickedNumbers.size()).isEqualTo(PICK_NUMBERS);
	}

	@Test
	void 뽑은_숫자들은_중복된_숫자가_없다() {
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(START_NUMBER, END_NUMBER, PICK_NUMBERS);

		Numbers lottoNumbers = lottoNumberGenerator.pickNumber();
		List<Integer> pickedNumbers = lottoNumbers.getNumbers();
		List<Integer> afterDistinctNumbers = pickedNumbers.stream()
				.distinct()
				.collect(Collectors.toList());

		assertThat(afterDistinctNumbers).isEqualTo(pickedNumbers);
	}
}
