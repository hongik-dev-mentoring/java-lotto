package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.InputException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputExceptionTest {
    @Test
    @DisplayName("최소금액입력시 예외 던지는지 테스트")
    public void handleMinimumTest() {
        // given
        int price = 900;
        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputException.handleMinimum(price));
    }

    @Test
    @DisplayName("로또 번호 범위 테스트")
    public void handleLottoNumberRangeTest() {
        // given
        int lottoNumber = 46;
        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> InputException.handleLottoNumberRange(lottoNumber));
    }

    @Test
    @DisplayName("로또 번호 중복 테스트")
    public void handleDuplicateTest() {
        // given
        List<Integer> lastLottoNumbers = List.of(1, 2, 3);
        int input = 1;
        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> InputException.handleDuplicate(lastLottoNumbers, input));
    }

    @Test
    @DisplayName("당첨번호가 6개만 입력되도록 테스트")
    public void handleLottoNumbersSizeTest() {
        // given
        List<Integer> lottoNumberList = List.of(1, 2, 3, 4, 5);
        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> InputException.handleLottoNumbersSize(lottoNumberList));
    }

    @Test
    @DisplayName("입력 문자열이 숫자형인지 테스트")
    public void handleInputFormatTest() {
        // given
        String input = "abc";
        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> InputException.handleInputFormat(input));
    }
}
