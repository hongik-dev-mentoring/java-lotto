package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> lastLottoNumbers;
    private final Integer bonusNumber;

    public LottoWinningNumbers(List<Integer> lastLottoNumbers, Integer bonusNumber) {
        this.lastLottoNumbers = new ArrayList<>(lastLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean isWinningNumber(int number) {
        return lastLottoNumbers.contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber == number;
    }
}
