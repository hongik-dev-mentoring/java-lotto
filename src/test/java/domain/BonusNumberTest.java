package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호를 숫자형만 입력할 수 있는지 테스트")
    public void handleBonusNumberFormatTest() {
        assertThatThrownBy(() -> {
                    BonusNumber bonusNumber = new BonusNumber("abc");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호 범위 예외 테스트")
    public void handleBonusNumberRangeTest() {
        assertThatThrownBy(() -> {
                    BonusNumber bonusNumber = new BonusNumber("47");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 1에서 45사이의 숫자여야 합니다.");
    }
}
