package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @Test
    @DisplayName("LottoNumbers 생성 테스트")
    public void createLottoNumbers() {
        //given
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(i);
        }
        //when
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        //then
        assertAll(
                () -> assertThat(lottoNumbers.getLottoNumbers().get(0)).isEqualTo(0),
                () -> assertThat(lottoNumbers.getLottoNumbers().get(1)).isEqualTo(1),
                () -> assertThat(lottoNumbers.getLottoNumbers().get(2)).isEqualTo(2),
                () -> assertThat(lottoNumbers.getLottoNumbers().get(3)).isEqualTo(3),
                () -> assertThat(lottoNumbers.getLottoNumbers().get(4)).isEqualTo(4),
                () -> assertThat(lottoNumbers.getLottoNumbers().get(5)).isEqualTo(5)
        );
    }
}
