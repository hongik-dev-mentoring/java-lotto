package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberPicker {
	private final int from;
	private final int to;
	private final int number;

	public RandomNumberPicker(int from, int to, int number) {
		this.from = from;
		this.to = to;
		this.number = number;
	}

	public Numbers pickNumber() {
		List<Integer> pickNumbers = IntStream.range(from, to)
			.boxed()
			.collect(Collectors.toList());

		List<Integer> shuffledNumbers = shuffleNumbers(pickNumbers);
		List<Integer> limitedNumbers = limitNumbers(shuffledNumbers);

		Collections.sort(limitedNumbers);
		return new Numbers(limitedNumbers);
	}

	private List<Integer> shuffleNumbers(List<Integer> numbers) {
		Collections.shuffle(numbers);
		return numbers;
	}

	private List<Integer> limitNumbers(List<Integer> numbers) {
		return numbers.stream()
			.limit(number)
			.collect(Collectors.toList());
	}
}
