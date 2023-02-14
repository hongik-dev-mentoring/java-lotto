package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또생성기 생성 테스트")
    void createLotto() {
        // when
        LottoNumbers lottoNumbers = LottoGenerator.generate();
        // then
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }
}
