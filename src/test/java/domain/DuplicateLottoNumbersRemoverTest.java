package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateLottoNumbersRemoverTest {
    @Test
    @DisplayName("LottoNumbers 중복 제거 테스트")
    void removeDuplicatesTest() {
        // given
        LottoTicket manualLottoTicket = createManualLottoTicket();
        LottoTicket autoLottoTicket = createAutoLottoTicket();
        // when
        DuplicateLottoNumbersRemover.removeDuplicates(manualLottoTicket, autoLottoTicket);
        // then
        LottoNumbers lottoNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
        assertThat(autoLottoTicket.contains(lottoNumbers)).isFalse();
    }

    private LottoTicket createManualLottoTicket() {
        List<LottoNumbers> manualLottoNumbersGroup = new ArrayList<>();
        manualLottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        manualLottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        return new LottoTicket(manualLottoNumbersGroup);
    }

    private LottoTicket createAutoLottoTicket() {
        List<LottoNumbers> autoLottoNumbersGroup = new ArrayList<>();
        autoLottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        autoLottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 7, 8, 9)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        ));
        return new LottoTicket(autoLottoNumbersGroup);
    }
}