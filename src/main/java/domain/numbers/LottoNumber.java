package domain.numbers;

import java.util.List;

public class LottoNumber {

	private static final int LOTTO_MINIMUM_NUMBER = 1;
	private static final int LOTTO_MAXIMUM_NUMBER = 46;
	private static final int LOTTO_SIZE = 6;

	private final List<Integer> numbers;

	public LottoNumber(List<Integer> numbers) {
		this.numbers = numbers;
		validateNumbersLength();
		validateDuplicatedNumber();
	}

	private void validateNumbersLength() {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.");
		}
	}

	private void validateDuplicatedNumber() {
		long count = getDistinctLottoNumber(numbers);
		if (count != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 불가능합니다.");
		}
	}

	private long getDistinctLottoNumber(List<Integer> numbers) {
		return numbers.stream()
			.distinct()
			.count();
	}

	public List<Integer> getNumbers() {
		return List.copyOf(numbers);
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}

	public static boolean checkInRange(int number) {
		return LOTTO_MINIMUM_NUMBER <= number && number < LOTTO_MAXIMUM_NUMBER;
	}

	public static LottoNumberGenerator createLottoNumberGenerator() {
		return new LottoNumberGenerator(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER, LOTTO_SIZE);
	}
}
