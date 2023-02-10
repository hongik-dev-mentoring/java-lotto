package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LastLottoNumbersTest {
    @Test
    @DisplayName("당첨번호에 숫자형만 입력할 수 있는지 테스트")
    public void handleLastLottoNumbersFormatTest() {
        Assertions.assertThatThrownBy(() -> {
                    LastLottoNumbers lastLottoNumbers = new LastLottoNumbers("1, 2, 3, 4, 5, abc");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 숫자여야 합니다.");
    }
    
    @Test
    @DisplayName("로또 번호 범위 예외 테스트")
    public void handleLottoNumberRangeTest() {
        Assertions.assertThatThrownBy(() -> {
                    LastLottoNumbers lastLottoNumbers = new LastLottoNumbers("1, 2, 3, 4, 5, 46");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 중복 예외 테스트")
    public void handleDuplicateTest() {
        Assertions.assertThatThrownBy(() -> {
                    LastLottoNumbers lastLottoNumbers = new LastLottoNumbers("1, 2, 3, 4, 5, 5");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 번호가 존재합니다.");
    }

    @Test
    @DisplayName("당첨번호가 6개만 입력되도록 하는지 테스트")
    public void handleLottoNumbersSizeTest() {
        Assertions.assertThatThrownBy(() -> {
                    LastLottoNumbers lastLottoNumbers = new LastLottoNumbers("1, 2, 3, 4, 5, 6, 7");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호 6개를 다시 입력해주세요.");
    }
}
