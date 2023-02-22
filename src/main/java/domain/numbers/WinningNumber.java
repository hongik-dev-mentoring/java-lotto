package domain.numbers;

import java.util.List;

public class WinningNumber {
	final LottoNumber lottoNumber;
	final int bonusBallNumber;

	public WinningNumber(LottoNumber winningNumbers, int bonusBallNumber) {
		validateBonusBallNumber(bonusBallNumber);
		validateDuplicateWithWinningNumber(winningNumbers, bonusBallNumber);
		this.lottoNumber = winningNumbers;
		this.bonusBallNumber = bonusBallNumber;
	}

	private void validateBonusBallNumber(int bonusBallNumber) {
		if (!LottoNumber.checkInRange(bonusBallNumber)) {
			throw new IllegalArgumentException("[ERROR] 보너스 볼은 1부터 45까지의 숫자여야 합니다.");
		}
	}

	private void validateDuplicateWithWinningNumber(LottoNumber winningNumbers, int bonusBallNumber) {
		if (winningNumbers.contains(bonusBallNumber)) {
			throw new IllegalArgumentException("[ERROR] 보너스 볼은 당첨 번호와 중복이 불가능합니다.");
		}
	}

	public LottoNumber getLottoNumbers() {
		return lottoNumber;
	}

	public List<Integer> getNumbers() {
		return List.copyOf(lottoNumber.getNumbers());
	}

	public int getBonusBallNumber() {
		return bonusBallNumber;
	}
}
