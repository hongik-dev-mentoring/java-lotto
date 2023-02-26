package domain.numbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

	private final int lottoMinimumNumber;
	private final int lottoMaximumNumber;
	private final int lottoSize;

	public LottoNumberGenerator() {
		this.lottoMinimumNumber = LottoNumber.getLottoMinimumNumber();
		this.lottoMaximumNumber = LottoNumber.getLottoMaximumNumber();
		this.lottoSize = LottoNumber.getLottoSize();
	}

	public LottoNumber pickNumber() {
		List<Integer> rangedNumbers = getRangedNumbers();
		Collections.shuffle(rangedNumbers);

		List<Integer> limitNumbers = getLimitedNumbers(rangedNumbers);
		Collections.sort(limitNumbers);

		return new LottoNumber(limitNumbers);
	}

	private List<Integer> getRangedNumbers() {
		return IntStream.range(lottoMinimumNumber, lottoMaximumNumber)
			.boxed()
			.collect(Collectors.toList());
	}

	private List<Integer> getLimitedNumbers(List<Integer> numbers) {
		return numbers.stream()
			.limit(lottoSize)
			.collect(Collectors.toList());
	}
}
