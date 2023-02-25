package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningNumbersTest {

    @Test
    @DisplayName("winningNumbers 안에 번호 포함시 true 반환 테스트")
    public void isContainNumber() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(i);
        }
        int bonusNumber = 7;
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(numbers, bonusNumber);
        //when
        assertAll(
                () -> assertThat(lottoWinningNumbers.isWinningNumber(3)).isEqualTo(true),
                () -> assertThat(lottoWinningNumbers.isBonusNumber(7)).isEqualTo(true)
        );
    }
}
