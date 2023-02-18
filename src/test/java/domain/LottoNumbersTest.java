package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @ParameterizedTest
    @DisplayName("로또 번호 중복 예외 테스트")
    @ValueSource(strings = {
            "1, 1, 1, 2, 3, 4",
            "1, 2, 3, 4, 5, 5",
            "1, 2, 3, 4, 4, 5"
    })
    public void checkLottoNumberDuplicateTest(String input) {
        List<LottoNumber> lottoNumbers = Arrays.stream(input.split(","))
                .map((number) -> new LottoNumber(Integer.parseInt(number.trim())))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 번호가 존재합니다.");
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 6개만 입력되도록 하는지 테스트")
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, 6, 7",
            "1, 2, 3, 4, 5",
    })
    public void checkLottoNumbersSizeTest(String input) {
        List<LottoNumber> lottoNumbers = Arrays.stream(input.split(","))
                .map((number) -> new LottoNumber(Integer.parseInt(number.trim())))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("LottoNumbers 동일성 테스트")
    public void lottoNumbersEqualsTest() {
        List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        List<LottoNumber> numbers2 = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers lottoNumbers2 = new LottoNumbers(numbers2);
        assertThat(lottoNumbers.equals(lottoNumbers2)).isTrue();
    }
}
