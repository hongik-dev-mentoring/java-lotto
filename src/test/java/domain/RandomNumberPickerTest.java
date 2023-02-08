package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class RandomNumberPickerTest {
	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 46;
	private static final int PICK_NUMBERS = 6;

	@Test
	void 범위내의_숫자를_뽑을수_있다() {
		RandomNumberPicker randomNumberPicker = new RandomNumberPicker(START_NUMBER, END_NUMBER, PICK_NUMBERS);

		Numbers numbers = randomNumberPicker.pickNumber();
		List<Integer> actualNumbers = numbers.getNumbers();

		List<Integer> expectedNumbers = List.copyOf(actualNumbers);
		List<Integer> afterFilteringNumbers = actualNumbers.stream()
			.filter(i -> i < END_NUMBER)
			.filter(i -> i >= START_NUMBER)
			.collect(Collectors.toList());

		assertThat(afterFilteringNumbers).isEqualTo(expectedNumbers);
	}
}
