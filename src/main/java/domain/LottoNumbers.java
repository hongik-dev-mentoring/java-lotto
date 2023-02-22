package domain;

import java.util.List;
import java.util.Set;

public class LottoNumbers {

	private static final String LOTTO_NUMBER_COUNT_MESSAGE = "[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.";
	private static final String LOTTO_NUMBER_DUPLICATE_MESSAGE = "[ERROR] 로또 번호는 중복이 불가능합니다.";
	private static final int LOTTO_NUMBERS_SIZE = 6;

	private final Set<LottoNumber> numbers;

	public LottoNumbers(Set<LottoNumber> numbers) {
		this.numbers = numbers;
		validateLength(numbers);
		validateDuplicate(numbers);
	}

	private void validateLength(Set<LottoNumber> numbers) {
		if (numbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_MESSAGE);
		}
	}

	private void validateDuplicate(Set<LottoNumber> numbers) {
		if (numbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_MESSAGE);
		}
	}

	public boolean contains(LottoNumber number) {
		return numbers.contains(number);
	}

	public List<LottoNumber> getNumbers() {
		return List.copyOf(numbers);
	}
}
