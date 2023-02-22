package domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private final int number;

	public LottoNumber(int number) {
		this.number = number;
		validateRange(number);
	}

	private void validateRange(int number) {
		if (checkRange(number)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다.");
		}
	}

	private static boolean checkRange(int number) {
		return number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER;
	}

	@Override
	public int compareTo(LottoNumber o) {
		return number - o.number;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	public int getNumber() {
		return number;
	}
}
