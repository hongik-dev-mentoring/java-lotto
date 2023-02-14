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
            return PRIZE_5TH.getPrizeKey();
        }
        if (count == 4) {
            return PRIZE_4TH.getPrizeKey();
        }
        if (count == 5 && hasBonusNumber) {
            return PRIZE_2ND.getPrizeKey();
        }
        if (count == 5) {
            return PRIZE_3RD.getPrizeKey();
        }
        if (count == 6) {
            return PRIZE_1ST.getPrizeKey();
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
