package util.convertor;

import static org.assertj.core.api.Assertions.*;

import domain.numbers.LottoNumber;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.numbers.WinningNumber;

public class LottoNumberConvertorTest {

	private static final String winningNumbers = "1, 2, 3, 4, 5, 6";

	@Test
	void 당첨_번호를_입력받아_정상_변환한다() {
		LottoNumber lottoNumbers = LottoNumberConvertor.convertLottoNumbers(winningNumbers);

		List<Integer> winningNumbers = lottoNumbers.getNumbers();
		List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		assertThat(winningNumbers).isEqualTo(expectedNumbers);
	}

	@Test
	void 당첨_번호는_숫자여야_한다() {
		assertThatThrownBy(() -> LottoNumberConvertor.convertLottoNumbers("a"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 숫자로만 구성 되어야 합니다. 다시 입력해주세요");
	}

	@ParameterizedTest(name = "{index} : 당첨 번호 {0} 입력")
	@ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
	void 당첨_번호는_여섯개여야_한다(String input) {
		assertThatThrownBy(() -> LottoNumberConvertor.convertLottoNumbers(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 여섯 개의 숫자여야 합니다.");
	}

	@Test
	void 보너스_번호를_입력받아_정상_변환한다() {
		Integer bonusNumber = LottoNumberConvertor.convertBonusNumber("7");

		Integer expectedNumber = 7;

		assertThat(bonusNumber).isEqualTo(expectedNumber);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "1, 2"})
	void 보너스_번호는_하나의_숫자여야_한다(String input) {
		assertThatThrownBy(() -> LottoNumberConvertor.convertBonusNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 한 개의 숫자여야 합니다. 다시 입력해주세요");
	}
}
