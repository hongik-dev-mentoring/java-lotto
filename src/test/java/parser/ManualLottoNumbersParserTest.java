package parser;

import domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottoNumbersParserTest {
    @Test
    @DisplayName("수동 로또 번호 변환 테스트")
    public void manualLottoNumbersParseTest() {
        // given
        List<String> manualLottoNumbers = Arrays.asList(
                "1,2,3,4,5,6",
                "7,8,9,10,11,12",
                "13,14,15,16,17,45"
        );
        // when
        List<LottoNumbers> lottoNumbers = ManualLottoNumbersParser.parse(manualLottoNumbers);
        // then
        assertThat(lottoNumbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("수동 로또 번호에 숫자형만 입력할 수 있는지 테스트")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, ###",
            "1, 2, 3, 4, 5, abc",
            "1, 2, 3, 4, 5, ABC",
    })
    public void manualLottoNumbersFormatTest(String input) {
        assertThatThrownBy(() -> ManualLottoNumbersParser.parse(Arrays.asList(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 숫자여야 합니다.");
    }
}