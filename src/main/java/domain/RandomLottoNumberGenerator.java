package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator {

	private static final List<Integer> lottoNumbers;
	private static final Random random;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	static {
		random = new Random();
		random.setSeed(System.currentTimeMillis());
		lottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
			.boxed()
			.collect(Collectors.toList());
	}

	public static LottoNumber generate() {
		int randomIndex = random.nextInt(lottoNumbers.size());
		return new LottoNumber(lottoNumbers.get(randomIndex));
	}
}
