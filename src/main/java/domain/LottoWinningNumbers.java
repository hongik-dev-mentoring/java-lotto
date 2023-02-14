package domain;

public class LottoWinningNumbers {
    private final LastLottoNumbers lastLottoNumbers;
    private final BonusNumber bonusNumber;

    public LottoWinningNumbers(LastLottoNumbers lastLottoNumbers, BonusNumber bonusNumber) {
        this.lastLottoNumbers = lastLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean containsLottoNumber(int number) {
        return lastLottoNumbers.containsLottoNumber(number);
    }

    public boolean containsBonusNumber(int number) {
        return bonusNumber.isBonusNumber(number);
    }
}
