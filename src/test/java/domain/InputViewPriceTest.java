package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewPriceTest {
    @Test
    @DisplayName("구매금액을 숫자형만 입력할 수 있는지 테스트")
    public void handleInputPriceFormatTest() {
        assertThatThrownBy(() -> {
                    InputPrice inputPrice = new InputPrice("abc");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("최소금액 예외 테스트")
    public void handleMinimumTest() {
        assertThatThrownBy(() -> {
                    InputPrice inputPrice = new InputPrice("900");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액은 1000원 이상이어야 합니다.");
    }
}
