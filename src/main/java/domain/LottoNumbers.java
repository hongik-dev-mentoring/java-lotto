package domain;

import java.util.List;

public class LottoNumbers {

	private final List<Numbers> numbers;

	public LottoNumbers(List<Numbers> numbers) {
		this.numbers = numbers;
	}

	public List<Numbers> getNumbers() {
		return List.copyOf(numbers);
	}
}
