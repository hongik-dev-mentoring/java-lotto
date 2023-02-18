package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumbersGeneratorTest {
    @Test
    @DisplayName("로또 생성 테스트")
    public void createLotto() {
        // when
        List<LottoNumbers> lottoNumbersGroup = LottoNumbersGenerator.generateLottoNumbersGroup(10);
        List<LottoNumber> lottoNumbers = lottoNumbersGroup.get(0).getLottoNumbers();
        // then
        assertAll(
                () -> assertThat(lottoNumbersGroup.size()).isEqualTo(10),
                () -> assertThat(lottoNumbers.size()).isEqualTo(6)
        );
    }
}