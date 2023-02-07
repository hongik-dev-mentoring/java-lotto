package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또생성기 생성")
    void createLotto() {
        // when
        List<Integer> lottoNumbers = LottoGenerator.generate();
        // then
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}