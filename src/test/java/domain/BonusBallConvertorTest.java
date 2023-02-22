package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class BonusBallConvertorTest {

	@Test
	void 보너스_볼은_한개의_숫자여야_한다() {
		assertThatThrownBy(() -> BonusBallConvertor.convertBonusNumber("1, 2"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 보너스 번호는 한 개의 숫자여야 합니다. 다시 입력해주세요");
	}
}