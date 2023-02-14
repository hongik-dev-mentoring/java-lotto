package parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputPriceParserTest {
    @ParameterizedTest
    @DisplayName("구매금액을 숫자형만 입력할 수 있는지 테스트")
    @ValueSource(strings = {"###", "abc", "ABC"})
    public void handleInputPriceFormatTest(String input) {
        assertThatThrownBy(() -> InputPriceParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("최소금액 예외 테스트")
    public void handleMinimumTest() {
        assertThatThrownBy(() -> InputPriceParser.parse("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 1000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("최소금액 경계값 테스트")
    public void inputPriceBoundaryValueTest() {
        int inputPrice = InputPriceParser.parse("1000");
        assertThat(inputPrice).isEqualTo(1000);
    }
}
