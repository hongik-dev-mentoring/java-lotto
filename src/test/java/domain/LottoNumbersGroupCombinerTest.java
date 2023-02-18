package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersGroupCombinerTest {
    @Test
    @DisplayName("combine 메소드 테스트")
    public void combineTest() {
        // given
        List<LottoNumbers> manualLottoNumbersGroup = new ArrayList<>();
        manualLottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        manualLottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));

        List<LottoNumbers> autoLottoNumbersGroup = new ArrayList<>();
        autoLottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 8)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        autoLottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 7, 8, 9)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        // when
        List<LottoNumbers> lottoNumbersGroup = LottoNumbersGroupCombiner.combine(manualLottoNumbersGroup, autoLottoNumbersGroup);
        // then
        assertThat(lottoNumbersGroup.size()).isEqualTo(4);
    }
}