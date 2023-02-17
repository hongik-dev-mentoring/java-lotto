package domain;

public class BonusBall {

	private final LottoNumber lottoNumber;
	private final WinningNumbers winningNumbers;

	public BonusBall(LottoNumber lottoNumber, WinningNumbers winningNumbers) {
		this.lottoNumber = lottoNumber;
		this.winningNumbers = winningNumbers;
		validateDuplicateWithWinningNumbers(lottoNumber, winningNumbers);
	}

	private void validateDuplicateWithWinningNumbers(LottoNumber lottoNumber, WinningNumbers winningNumbers) {
		if (winningNumbers.contains(lottoNumber)) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 볼은 중복이 불가능합니다.");
		}
	}

	public LottoNumber getLottoNumber() {
		return lottoNumber;
	}
}
