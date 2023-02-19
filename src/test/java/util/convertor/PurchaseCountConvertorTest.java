package util.convertor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseCountConvertorTest {

    @Test
    void 구입_갯수를_숫자로_변횐할수_있다() {
        Integer purchaseCount = PurchaseCountConvertor.convertPurchaseCount("5");

        assertThat(purchaseCount).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ABC"})
    void 구입_갯수는_숫자여야_한다(String input) {

        assertThatThrownBy(() -> PurchaseCountConvertor.convertPurchaseCount(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 수동 로또 구매 갯수는 숫자여야 합니다. 다시 입력해주세요");
    }

    @Test
    void 구입_갯구는_0개_이상이어야_한다() {

        assertThatThrownBy(() -> PurchaseCountConvertor.convertPurchaseCount("-5"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 수동 로또 구매 갯수는 0개 이상이어야 합니다. 다시 입력해주세요");
    }
}
