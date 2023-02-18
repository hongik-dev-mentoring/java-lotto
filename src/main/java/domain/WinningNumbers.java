package domain;

import java.util.Set;

public class WinningNumbers {

	private static final int LOTTO_NUMBER = 6;

	private final Set<LottoNumber> winningNumbers;

	public WinningNumbers(Set<LottoNumber> winningNumbers) {
		this.winningNumbers = winningNumbers;
		validateWinningNumbersLength(winningNumbers);
		validateDuplicate(winningNumbers);
	}

	private void validateWinningNumbersLength(Set<LottoNumber> numbers) {
		if (numbers.size() != LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 여섯 개의 숫자여야 합니다.");
		}
	}

	private void validateDuplicate(Set<LottoNumber> numbers) {
		long count = getDistinctLottoNumber(numbers);
		if (count != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 불가능합니다.");
		}
	}

	private long getDistinctLottoNumber(Set<LottoNumber> numbers) {
		return numbers.stream()
			.distinct()
			.count();
	}

	public Set<LottoNumber> getNumbers() {
		return Set.copyOf(winningNumbers);
	}

	public boolean contains(LottoNumber number) {
		return winningNumbers.contains(number);
	}
}
