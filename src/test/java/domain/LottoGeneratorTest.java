package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    private LottoGenerator generator = new LottoGenerator();

    @BeforeEach
    void createLottoGenerator() {
        generator = new LottoGenerator();
    }

    @Test
    @DisplayName("로또생성기 생성")
    void createLotto() {
        // when
        List<Integer> lottoNumbers = generator.generate();
        // then
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}