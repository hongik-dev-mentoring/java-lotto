package domain;

import java.util.List;

public class Numbers {
	private final List<Integer> numbers;

	public Numbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return List.copyOf(numbers);
	}

	public boolean contains(Integer value) {
		return numbers.contains(value);
	}
}
