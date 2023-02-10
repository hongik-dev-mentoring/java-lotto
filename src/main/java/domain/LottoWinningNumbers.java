package domain;

public class LottoWinningNumbers {
    private final LastLottoNumbers lastLottoNumbers;
    private final BonusNumber bonusNumber;

    public LottoWinningNumbers(LastLottoNumbers lastLottoNumbers, BonusNumber bonusNumber) {
        this.lastLottoNumbers = lastLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isWinningNumber(int number) {
        return lastLottoNumbers.getLastLottoNumbers().contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber.getBonusNumber() == number;
    }
}
