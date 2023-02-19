package util.convertor;

import static org.assertj.core.api.Assertions.assertThat;

import domain.numbers.LottoNumbers;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ManualLottoNumbersConvertorTest {

    private static final String input = "1, 2, 3, 4, 5, 6";

    @Test
    void 당첨_번호를_입력받아_변환이_가능하다() {
        LottoNumbers manualLottoNumbers = ManualLottoNumbersConvertor.convertManualNumbers(input);

        List<Integer> actualNumbers  = manualLottoNumbers.getNumbers();
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(actualNumbers).isEqualTo(expectedNumbers);
    }
}
