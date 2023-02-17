package parser;

import domain.LottoNumber;
import domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LastLottoNumbersParserTest {
    @ParameterizedTest
    @DisplayName("당첨번호에 숫자형만 입력할 수 있는지 테스트")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, ###",
            "1, 2, 3, 4, 5, abc",
            "1, 2, 3, 4, 5, ABC",
    })
    public void handleLastLottoNumbersFormatTest(String input) {
        assertThatThrownBy(() -> LastLottoNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 숫자여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("로또 번호 범위 예외 테스트")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, 46",
            "0, 2, 3, 4, 5, 45"
    })
    public void handleLottoNumberRangeTest(String input) {
        assertThatThrownBy(() -> LastLottoNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1에서 45사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호 경계값 테스트")
    public void lottoNumberBoundaryValueTest() {
        LottoNumbers lastLottoNumbers = LastLottoNumbersParser.parse("1, 2, 3, 4, 5, 45");
        assertThat(lastLottoNumbers.contains(new LottoNumber(45))).isTrue();
    }

    @ParameterizedTest
    @DisplayName("로또 번호 중복 예외 테스트")
    @ValueSource(strings = {
            "1, 1, 1, 2, 3, 4",
            "1, 2, 3, 4, 5, 5",
            "1, 2, 3, 4, 4, 5"
    })
    public void handleDuplicateTest(String input) {
        assertThatThrownBy(() -> LastLottoNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 번호가 존재합니다.");
    }

    @ParameterizedTest
    @DisplayName("당첨번호가 6개만 입력되도록 하는지 테스트")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, 6, 7",
            "1, 2, 3, 4, 5",
    })
    public void handleLottoNumbersSizeTest(String input) {
        assertThatThrownBy(() -> LastLottoNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호 6개를 다시 입력해주세요.");
    }
}
