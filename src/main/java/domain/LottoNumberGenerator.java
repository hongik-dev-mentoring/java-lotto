package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
	private final int from;
	private final int to;
	private final int number;

	public LottoNumberGenerator(int from, int to, int number) {
		this.from = from;
		this.to = to;
		this.number = number;
	}

	public LottoNumbers pickNumber() {
		List<Integer> pickNumbers = IntStream.range(from, to)
			.boxed()
			.collect(Collectors.toList());

		shuffleNumbers(pickNumbers);
		List<Integer> limitNumbers = getLimitedNumbers(pickNumbers);
		sortNumbers(limitNumbers);
		return new LottoNumbers(limitNumbers);
	}

	private void shuffleNumbers(List<Integer> numbers) {
		Collections.shuffle(numbers);
	}

	private List<Integer> getLimitedNumbers(List<Integer> numbers) {
		return numbers.stream()
			.limit(number)
			.collect(Collectors.toList());
	}

	private void sortNumbers(List<Integer> numbers) {
		Collections.sort(numbers);
	}
}
