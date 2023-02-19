package domain.numbers;

import java.util.List;

public abstract class Numbers {

	protected final List<Integer> numbers;

	public Numbers(List<Integer> numbers) {
		this.numbers = numbers;
		validateNumbersLength();
		validateDuplicatedNumber();
	}

	protected abstract void validateNumbersLength();
	protected abstract void validateDuplicatedNumber();

	public List<Integer> getNumbers() {
		return List.copyOf(numbers);
	}

	public boolean contains(Integer value) {
		return numbers.contains(value);
	}
}
