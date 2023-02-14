package domain;

import static domain.LottoPrize.*;

public class LottoNumberCounter {
    private static final int INITIAL_COUNT = 0;

    private int count;
    private boolean hasBonusNumber;

    public LottoNumberCounter() {
        this.count = INITIAL_COUNT;
        this.hasBonusNumber = false;
    }

    public void countLottoNumbers(LottoWinningNumbers lottoWinningNumbers, int number) {
        if (lottoWinningNumbers.isWinningNumber(number)) {
            count++;
        }
    }

    public void countBonusNumber(LottoWinningNumbers lottoWinningNumbers, int number) {
        if (lottoWinningNumbers.isBonusNumber(number)) {
            count++;
            hasBonusNumber = true;
        }
    }

    public String decideLottoPrize() {
        if (count == 3) {
            return FIFTH_PRIZE.getPrizeKey();
        }
        if (count == 4) {
            return FOURTH_PRIZE.getPrizeKey();
        }
        if (count == 5 && hasBonusNumber) {
            return SECOND_PRIZE.getPrizeKey();
        }
        if (count == 5) {
            return THIRD_PRIZE.getPrizeKey();
        }
        if (count == 6) {
            return FIRST_PRIZE.getPrizeKey();
        }
        return NO_PRIZE.getPrizeKey();
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
