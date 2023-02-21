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
        LottoTicket lottoTicket = LottoNumbersAutoGenerator.generateAutoLottoTicket(10);
        assertThat(lottoTicket.getLottoNumbersGroup().size()).isEqualTo(10);
    }
}