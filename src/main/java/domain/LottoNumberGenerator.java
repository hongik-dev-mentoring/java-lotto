package domain;

import domain.numbers.LottoNumbers;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

	private final LottoNumberRange lottoNumberRange;
	private final int lottoSize;

	public LottoNumberGenerator(LottoNumberRange lottoNumberRange, int lottoSize) {
		this.lottoNumberRange = lottoNumberRange;
		this.lottoSize = lottoSize;
	}

	public LottoNumbers pickNumber() {
		List<Integer> rangedNumbers = getRangedNumbers();

		Collections.shuffle(rangedNumbers);
		List<Integer> limitNumbers = getLimitedNumbers(rangedNumbers);
		Collections.sort(limitNumbers);
		return new LottoNumbers(limitNumbers);
	}

	private List<Integer> getLimitedNumbers(List<Integer> numbers) {
		return numbers.stream()
			.limit(lottoSize)
			.collect(Collectors.toList());
	}

	private List<Integer> getRangedNumbers() {
		int startNumber = lottoNumberRange.getStartNumber();
		int endNumber = lottoNumberRange.getEndNumber();

		return IntStream.range(startNumber, endNumber)
			.boxed()
			.collect(Collectors.toList());
	}
}
