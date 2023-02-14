package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> lastLottoNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(List<Integer> lastLottoNumbers, int bonusNumber) {
        this.lastLottoNumbers = new ArrayList<>(lastLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean containsLottoNumber(int number) {
        return lastLottoNumbers.contains(number);
    }

    public boolean containsBonusNumber(int number) {
        return bonusNumber == number;
    }
}
