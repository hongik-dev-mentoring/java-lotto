package util.convertor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PurchaseCountConvertorTest {

    @Test
    void 구입_갯수를_숫자로_변횐할수_있다() {
        Integer purchaseCount = PurchaseCountConvertor.convertPurchaseCount("5");

        assertThat(purchaseCount).isEqualTo(5);
    }
}
