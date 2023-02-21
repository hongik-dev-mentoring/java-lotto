package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> winningLottoNumbers;
    private final Integer bonusNumber;

    public LottoWinningNumbers(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        this.winningLottoNumbers = new ArrayList<>(winningLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean isWinningNumber(int number) {
        return winningLottoNumbers.contains(number);
    }

    public boolean isBonusNumber(int number) {
        return bonusNumber == number;
    }
}
