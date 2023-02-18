package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersAutoGeneratorTest {
    @Test
    @DisplayName("로또 번호 생성 테스트")
    public void generateLottoNumbersTest() {
        List<LottoNumber> lottoNumbers = LottoNumbersAutoGenerator.generateAutoLottoNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 그룹 생성 테스트")
    public void generateLottoNumbersGroupTest() {
        List<LottoNumbers> autoLottoNumbersGroup = LottoNumbersAutoGenerator.generateAutoLottoNumbersGroup(10);
        assertThat(autoLottoNumbersGroup.size()).isEqualTo(10);
    }
}