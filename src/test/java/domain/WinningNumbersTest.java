package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import java.util.List;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class WinningNumbersTest {

	@Test
	void 당첨_번호는_여섯_개의_숫자여야_한다() {
		assertThatThrownBy(() -> new WinningNumbers(List.of(new LottoNumber(1),
			new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5))))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨 번호는 여섯 개의 숫자여야 합니다.");
	}

	@Test
	void 당첨_번호는_중복이_불가능하다() {
		assertThatThrownBy(() -> new WinningNumbers(List.of(new LottoNumber(1), new LottoNumber(2),
			new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(5))))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨 번호는 중복이 불가능합니다.");
	}

}