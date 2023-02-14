package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또생성기 생성")
    void createLotto() {
        // when
        LottoDto lottoDto = LottoGenerator.generate();
        // then
        assertThat(lottoDto.getLottoNumbers().size()).isEqualTo(6);
    }
}