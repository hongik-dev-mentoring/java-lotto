package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호를 숫자형만 입력할 수 있는지 테스트")
    public void handleBonusNumberFormatTest() {
        Assertions.assertThatThrownBy(() -> {
                    BonusNumber bonusNumber = new BonusNumber("abc");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호 범위 예외 테스트")
    public void handleBonusNumberRangeTest() {
        Assertions.assertThatThrownBy(() -> {
                    BonusNumber bonusNumber = new BonusNumber("47");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 1에서 45사이의 숫자여야 합니다.");
    }
}
