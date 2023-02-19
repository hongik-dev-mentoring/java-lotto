package domain.numbers;

import java.util.List;

public class LottoNumbers {

	protected static final int LOTTO_SIZE = 6;

	protected final List<Integer> numbers;

	public LottoNumbers(List<Integer> numbers) {
		this.numbers = numbers;
		validateNumbersLength();
		validateDuplicatedNumber();
	}

	protected void validateNumbersLength() {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.");
		}
	}

	protected void validateDuplicatedNumber() {
		long count = getDistinctLottoNumber(numbers);
		if (count != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 불가능합니다.");
		}
	}

	protected long getDistinctLottoNumber(List<Integer> numbers) {
		return numbers.stream()
			.distinct()
			.count();
	}

	public List<Integer> getNumbers() {
		return List.copyOf(numbers);
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}
}
