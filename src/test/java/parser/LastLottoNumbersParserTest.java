package parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LastLottoNumbersParserTest {
    @ParameterizedTest
    @DisplayName("당첨 번호에 숫자형만 입력할 수 있는지 테스트")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, ###",
            "1, 2, 3, 4, 5, abc",
            "1, 2, 3, 4, 5, ABC",
    })
    public void lottoNumbersFormatTest(String input) {
        assertThatThrownBy(() -> LastLottoNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 숫자여야 합니다.");
    }
}
