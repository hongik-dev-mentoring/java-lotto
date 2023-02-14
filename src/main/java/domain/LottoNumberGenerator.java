package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_NUMBER_LENGTH = 6;

	public LottoNumbers generateLottoNumbers() {
		List<Integer> pickNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
			.boxed()
			.collect(Collectors.toList());

		Collections.shuffle(pickNumbers);
		List<Integer> limitNumbers = getLimitedNumbers(pickNumbers);
		Collections.sort(limitNumbers);

		return new LottoNumbers(limitNumbers);
	}

	private List<Integer> getLimitedNumbers(List<Integer> numbers) {
		return numbers.stream()
			.limit(LOTTO_NUMBER_LENGTH)
			.collect(Collectors.toList());
	}
}
