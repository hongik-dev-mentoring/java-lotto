package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BonusBallTest {

	@Test
	void 보너스_번호는_로또_번호의_범위_내에_있어야_한다() {

		assertThatThrownBy(() -> BonusBall.createBonusBallInRange(1, 45, 50))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 보너스 볼은 1부터 45까지의 숫자여야 합니다.");
	}

}