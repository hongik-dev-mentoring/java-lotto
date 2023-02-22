package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LottoNumbersTest {

	@Test
	void 로또_번호는_여섯_개의_숫자여야_한다() {
		Set<LottoNumber> lottoNumbers = Set.of(new LottoNumber(1),
			new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5));

		assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.");
	}
}
