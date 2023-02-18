package domain;

import java.util.List;
import java.util.Set;

public class LottoNumbers {

	private static final String LOTTO_NUMBER_COUNT_MESSAGE = "[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.";
	private static final int LOTTO_NUMBERS_SIZE = 6;

	private final Set<LottoNumber> numbers;

	public LottoNumbers(Set<LottoNumber> numbers) {
		this.numbers = numbers;
		validateLength(numbers);
	}

	private void validateLength(Set<LottoNumber> numbers) {
		if (numbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_MESSAGE);
		}
	}

	public boolean contains(LottoNumber number) {
		return numbers.contains(number);
	}

	public List<LottoNumber> getNumbers() {
		return List.copyOf(numbers);
	}
}
