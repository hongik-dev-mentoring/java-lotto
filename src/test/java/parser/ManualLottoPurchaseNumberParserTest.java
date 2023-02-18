package parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottoPurchaseNumberParserTest {
    @ParameterizedTest
    @DisplayName("수동 로또 구매횟수를 숫자형만 입력할 수 있는지 테스트")
    @ValueSource(strings = {"###", "abc", "ABC"})
    public void manualLottoPurchaseNumberFormatTest(String input) {
        assertThatThrownBy(() -> ManualLottoPurchaseNumberParser.parse(input, 14))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입할 수동 로또의 개수는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("수동 로또 구매횟수 제한 예외 테스트")
    public void manualLottoPurchaseNumberLimitTest() {
        assertThatThrownBy(() -> ManualLottoPurchaseNumberParser.parse("15", 14))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 로또 금액이 총 구입금액을 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("수동 로또 구매횟수 변환 테스트")
    public void manualLottoPurchaseNumberParseTest() {
        int manualPurchaseNumber = ManualLottoPurchaseNumberParser.parse("3", 14);
        assertThat(manualPurchaseNumber).isEqualTo(3);
    }
}