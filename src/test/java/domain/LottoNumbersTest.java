package domain;

import static org.assertj.core.api.Assertions.*;

import domain.numbers.LottoNumbers;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumbersTest {

	@Test
	void 정수_리스트를_받아_LottoNumbers_객체를_만들_수_있다() {
		List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		LottoNumbers lottoNumbers = new LottoNumbers(inputNumbers);
		List<Integer> actualLottoNumbers = lottoNumbers.getNumbers();

		assertThat(actualLottoNumbers).isEqualTo(inputNumbers);
	}

	@ParameterizedTest(name = "{index} 숫자가 {0} 일 때")
	@ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
	void 로또_번호는_여섯개의_숫자여야_한다(String input) {
		List<Integer> wrongLottoNumbers = Arrays.stream(input.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		assertThatThrownBy(() -> new LottoNumbers(wrongLottoNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.");
	}

	@Test
	void 로또_번호는_중복일수_없다() {
		List<Integer> duplicatedLottoNumbers = List.of(1,2,3,4,5,5);

		assertThatThrownBy(() -> new LottoNumbers(duplicatedLottoNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 중복이 불가능합니다.");
	}
}
