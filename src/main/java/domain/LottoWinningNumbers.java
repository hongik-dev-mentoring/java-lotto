package domain;

public class LottoWinningNumbers {
    private final LottoNumbers lastLottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumbers(LottoNumbers lastLottoNumbers, LottoNumber bonusNumber) {
        this.lastLottoNumbers = lastLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean containsLottoNumber(LottoNumber lottoNumber) {
        return lastLottoNumbers.contains(lottoNumber);
    }

    public boolean containsBonusNumber(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
