package domain;

import static domain.LottoPrize.*;

public class LottoNumberCounter {
    private static final int INITIAL_COUNT = 0;

    private final LottoWinningNumbers lottoWinningNumbers;
    private int count;
    private boolean hasBonusNumber;

    public LottoNumberCounter(LottoWinningNumbers lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.count = INITIAL_COUNT;
        this.hasBonusNumber = false;
    }

    public void countLottoNumbers(int number) {
        if (checkContainsLottoNumber(number) || checkContainsBonusNumber(number)) {
            count++;
        }
    }

    private boolean checkContainsLottoNumber(int number) {
        return lottoWinningNumbers.containsLottoNumber(number);
    }

    private boolean checkContainsBonusNumber(int number) {
        hasBonusNumber = lottoWinningNumbers.containsBonusNumber(number);
        return hasBonusNumber;
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
}
