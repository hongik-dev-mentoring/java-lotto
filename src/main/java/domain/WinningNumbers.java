package domain;

import java.util.List;

public class WinningNumbers implements Numbers {

	private static final int LOTTO_NUMBER = 6;

	private final List<Integer> winningNumbers;

	public WinningNumbers(List<Integer> winningNumbers) {
		this.winningNumbers = winningNumbers;
		validateWinningNumbersLength(winningNumbers);
		validateDuplicate(winningNumbers);
	}

	private void validateWinningNumbersLength(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 여섯 개의 숫자여야 합니다.");
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		long count = getDistinctLottoNumber(numbers);
		if (count != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 불가능합니다.");
		}
	}

	private long getDistinctLottoNumber(List<Integer> numbers) {
		return numbers.stream()
			.distinct()
			.count();
	}

	@Override
	public List<Integer> getNumbers() {
		return List.copyOf(winningNumbers);
	}

	@Override
	public boolean contains(int value) {
		return winningNumbers.contains(value);
	}
}
