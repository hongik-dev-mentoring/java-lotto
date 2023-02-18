package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 46})
	void 로또_번호가_1에서_45까지의_숫자가_아니면_예외가_발생한다(int number) {
		assertThatThrownBy(() -> new LottoNumber(number))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}
}
