package domain;

import static org.assertj.core.api.Assertions.*;

import domain.numbers.WinningNumbers;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusBallTest {

	@Test
	void 보너스_번호는_로또_번호의_범위_내에_있어야_한다() {
		WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

		assertThatThrownBy(() -> BonusBall.createBonusBallInRange(1, 45, 50, winningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 보너스 볼은 1부터 45까지의 숫자여야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5,6})
	void 보너스_번호는_당첨_번호와_중복될_수_없다(int input) {
		WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

		assertThatThrownBy(() -> BonusBall.createBonusBallInRange(1, 45, input, winningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 보너스 볼은 당첨 번호와 중복이 불가능합니다.");
	}
}
