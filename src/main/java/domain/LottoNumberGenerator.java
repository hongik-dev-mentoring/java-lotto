package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

	private final int startNumber;
	private final int endNumber;
	private final int limitNumber;

	public LottoNumberGenerator(int startNumber, int endNumber, int limitNumber) {
		this.startNumber = startNumber;
		this.endNumber = endNumber;
		this.limitNumber = limitNumber;
	}

	public LottoNumbers generateLottoNumbers() {
		List<Integer> pickNumbers = IntStream.range(startNumber, endNumber)
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
			.limit(limitNumber)
			.collect(Collectors.toList());
	}

	private void sortNumbers(List<Integer> numbers) {
		Collections.sort(numbers);
	}
}
