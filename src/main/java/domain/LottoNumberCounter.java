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

    public String decideLottoPrize() {
        if (count == 3) {
            return LottoConstant.FIFTH_PRIZE_KEY;
        }
        if (count == 4) {
            return LottoConstant.FOURTH_PRIZE_KEY;
        }
        if (count == 5 && hasBonusNumber) {
            return LottoConstant.SECOND_PRIZE_KEY;
        }
        if (count == 5) {
            return LottoConstant.THIRD_PRIZE_KEY;
        }
        if (count == 6) {
            return LottoConstant.FIRST_PRIZE_KEY;
        }
        return LottoConstant.NO_PRIZE_KEY;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
