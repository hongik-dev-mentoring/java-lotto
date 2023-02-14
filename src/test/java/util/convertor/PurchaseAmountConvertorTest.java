package util.convertor;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.PurchaseAmountConvertor;

class PurchaseAmountConvertorTest {

	@Test
	void 구입_금액을_숫자로_변환할수_있다() {
		Integer purchaseAmount = PurchaseAmountConvertor.convertPurchaseAmount("14000");

		assertThat(purchaseAmount).isEqualTo(14000);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "ABC"})
	void 로또_구입_금액은_숫자여야_한다(String input) {
		assertThatThrownBy(() -> PurchaseAmountConvertor.convertPurchaseAmount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 금액은 숫자여야 합니다. 다시 입력해주세요");
	}

	@Test
	void 로또_구입_금액은_0원_이상이어야_한다() {
		assertThatThrownBy(() -> PurchaseAmountConvertor.convertPurchaseAmount("-22000"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 금액은 0원 이상이어야 합니다. 다시 입력해주세요");
	}
}
