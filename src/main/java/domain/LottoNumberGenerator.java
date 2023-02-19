package domain;

import domain.numbers.LottoNumbers;
import domain.numbers.Numbers;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

	private final int startNumber;
	private final int endNumber;
	private final int lottoSize;

	public LottoNumberGenerator(int startNumber, int endNumber, int lottoSize) {
		this.startNumber = startNumber;
		this.endNumber = endNumber;
		this.lottoSize = lottoSize;
	}

	public Numbers pickNumber() {
		List<Integer> pickNumbers = IntStream.range(startNumber, endNumber)
			.boxed()
			.collect(Collectors.toList());

		Collections.shuffle(pickNumbers);
		List<Integer> limitNumbers = getLimitedNumbers(pickNumbers);
		Collections.sort(limitNumbers);
		return new LottoNumbers(limitNumbers);
	}

	private List<Integer> getLimitedNumbers(List<Integer> numbers) {
		return numbers.stream()
			.limit(lottoSize)
			.collect(Collectors.toList());
	}
}
