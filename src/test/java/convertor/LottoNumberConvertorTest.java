package convertor;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.Numbers;

public class LottoNumberConvertorTest {

	private static final String winningNumbers = "1, 2, 3, 4, 5, 6";

	@Test
	void 당첨_번호를_입력받아_정상_변환한다() {
		Numbers numbers = LottoNumberConvertor.convertWinningNumber(winningNumbers);

		List<Integer> winningNumbers = numbers.getNumbers();
		List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		Assertions.assertThat(winningNumbers).isEqualTo(expectedNumbers);
	}

}
