package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class WinningNumberConvertorTest {

	@Test
	void 당첨_번호는_숫자여야_한다() {
		assertThatThrownBy(() -> WinningNumberConvertor.convertWinningNumber("thousand"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨 번호는 숫자여야 합니다. 다시 입력해주세요");
	}
}