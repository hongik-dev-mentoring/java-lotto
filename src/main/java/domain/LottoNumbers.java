package domain;

import java.util.List;

public class LottoNumbers {
	private final List<Integer> numbers;
	private static final int LOTTO_NUMBER = 6;

	public LottoNumbers(List<Integer> numbers) {
		this.numbers = numbers;
		validateLottoNumbersLength(numbers);
	}

	private void validateLottoNumbersLength(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.");
		}
	}

	public List<Integer> getNumbers() {
		return List.copyOf(numbers);
	}

	public boolean contains(Integer value) {
		return numbers.contains(value);
	}


}
