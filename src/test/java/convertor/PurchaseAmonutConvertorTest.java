package convertor;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmonutConvertorTest {

	@Test
	void 구입_금액을_숫자로_변횐할수_있다() {
		Integer purchaseAmount = PurchaseAmonutConvertor.getPurchaseAmount("14000");

		assertThat(purchaseAmount).isEqualTo(14000);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "ABC"})
	void 로또_구입_금액은_숫자여야_한다(String input) {

		assertThatThrownBy(() -> PurchaseAmonutConvertor.getPurchaseAmount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 금액은 숫자여야 합니다. 다시 입력해주세요");
	}

}