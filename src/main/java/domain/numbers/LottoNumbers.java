package domain.numbers;

import java.util.List;

public class LottoNumbers extends Numbers {

	private static final int LOTTO_SIZE = 6;

	public LottoNumbers(List<Integer> lottoNumbers) {
		super(lottoNumbers);
	}

	@Override
	protected void validateNumbersLength() {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.");
		}
	}

	@Override
	protected void validateDuplicatedNumber() {
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
}
