package domain;

public class LottoNumberCounter {
    private static final int INITIAL_COUNT = 0;

    private int count;
    private boolean hasBonusNumber;
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoNumberCounter(LottoWinningNumbers lottoWinningNumbers) {
        this.count = INITIAL_COUNT;
        this.hasBonusNumber = false;
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public void countLottoNumbers(int number) {
        if (lottoWinningNumbers.isWinningNumber(number)) {
            count++;
        }
    }

    public void countBonusNumber(int number) {
        if (lottoWinningNumbers.isBonusNumber(number)) {
            count++;
            hasBonusNumber = true;
        }
    }

    public LottoPrize decideLottoPrize() {
        return LottoPrize.decideLottoPrize(count, hasBonusNumber);
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
