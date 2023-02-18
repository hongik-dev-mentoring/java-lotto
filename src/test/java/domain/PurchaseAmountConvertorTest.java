package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class PurchaseAmountConvertorTest {

	@Test
	void 로또_구입_금액은_숫자여야_한다() {
		assertThatThrownBy(() -> PurchaseAmountConvertor.convertPurchaseAmount("thousand"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@Test
	void 로또_구입_금액은_0원_이상이어야_한다() {
		assertThatThrownBy(() -> PurchaseAmountConvertor.convertPurchaseAmount("-1000"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}
}