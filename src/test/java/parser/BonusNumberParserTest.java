package parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberParserTest {
    @DisplayName("보너스 번호를 숫자형만 입력할 수 있는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"###", "abc", "ABC"})
    public void handleBonusNumberFormatTest(String input) {
        assertThatThrownBy(() -> BonusNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 숫자여야 합니다.");
    }
}
