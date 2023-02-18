package util.generator;

import java.util.Random;

import domain.LottoNumber;

public class RandomLottoNumberGenerator {

	private static final Random random;
	private static final int MAX_LOTTO_NUMBER = 45;

	static {
		random = new Random();
		random.setSeed(System.currentTimeMillis());
	}

	public static LottoNumber generate() {
		return new LottoNumber(random.nextInt(MAX_LOTTO_NUMBER) + 1);
	}
}
