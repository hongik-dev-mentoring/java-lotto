package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class BonusBallTest {

	@ParameterizedTest(name = "보너스볼이 {0}일 때")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	void 보너스볼은_당첨_숫자와_중복이_불가능하다(int number) {
		Set<LottoNumber> lottoNumbers = Set.of(new LottoNumber(1),new LottoNumber(2),
			new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
		WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);

		assertThatThrownBy(() -> new BonusBall(new LottoNumber(number), winningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨 번호와 보너스 볼은 중복이 불가능합니다.");
	}
}
