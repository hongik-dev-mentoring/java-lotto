package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또생성기 생성 테스트")
    void createLotto() {
        // when
        LottoDto lottoDto = LottoGenerator.generate();
        // then
        Assertions.assertThat(lottoDto.getLottoNumbers().size()).isEqualTo(6);
    }
}
