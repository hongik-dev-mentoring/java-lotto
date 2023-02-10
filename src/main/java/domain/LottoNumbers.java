package domain;

import java.util.List;

public class LottoNumbers implements Numbers {

	private final List<Integer> numbers;
	private static final int LOTTO_NUMBER = 6;

	public LottoNumbers(List<Integer> numbers) {
		this.numbers = numbers;
		validateLottoNumbersLength(numbers);
		validateDuplicatedNumber(numbers);
	}

	private void validateLottoNumbersLength(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.");
		}
	}

	private void validateDuplicatedNumber(List<Integer> numbers) {
		long count = getDistinctLottoNumber(numbers);
		if (count != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 불가능합니다.");
		}
	}

	private long getDistinctLottoNumber(List<Integer> numbers) {
		return numbers.stream()
			.distinct()
			.count();
	}

	@Override
	public List<Integer> getNumbers() {
		return List.copyOf(numbers);
	}

	@Override
	public boolean contains(Integer value) {
		return numbers.contains(value);
	}
}
