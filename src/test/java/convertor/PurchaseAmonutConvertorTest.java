package convertor;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseAmonutConvertorTest {

	@Test
	void 구입_금액을_숫자로_변횐할수_있다() {
		Integer purchaseAmount = PurchaseAmonutConvertor.getPurchaseAmount("14000");

		assertThat(purchaseAmount).isEqualTo(14000);
	}

}