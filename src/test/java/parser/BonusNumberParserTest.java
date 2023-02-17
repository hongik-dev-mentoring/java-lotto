package parser;

import domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46", "47"})
    @DisplayName("보너스 번호 범위 예외 테스트")
    public void handleBonusNumberRangeTest(String input) {
        assertThatThrownBy(() -> BonusNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1에서 45사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    @DisplayName("보너스 번호 경계값 테스트")
    public void bonusNumberBoundaryValueTest(String input) {
        LottoNumber bonusNumber = BonusNumberParser.parse(input);
        LottoNumber expectedNumber = new LottoNumber(Integer.parseInt(input));
        assertThat(bonusNumber.equals(expectedNumber)).isTrue();
    }
}
