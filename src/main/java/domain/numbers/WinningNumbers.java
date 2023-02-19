package domain.numbers;

import java.util.List;

public class WinningNumbers extends LottoNumbers {

	public WinningNumbers(List<Integer> winningNumbers) {
		super(winningNumbers);
	}

	@Override
	protected void validateNumbersLength() {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 여섯 개의 숫자여야 합니다.");
		}
	}

	@Override
	protected void validateDuplicatedNumber() {
		long count = getDistinctLottoNumber(numbers);
		if (count != numbers.size()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 불가능합니다.");
		}
	}
}
