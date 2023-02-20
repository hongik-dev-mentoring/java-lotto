package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    @Test
    @DisplayName("combine 메소드 테스트")
    public void combineTest() {
        // given
        LottoTicket manualLottoTicket = createManualLottoTicket();
        LottoTicket autoLottoTicket = createAutoLottoTicket();
        // when
        LottoTicket lottoTicket = autoLottoTicket.combine(manualLottoTicket);
        // then
        assertThat(lottoTicket.getLottoNumbersGroup().size()).isEqualTo(4);
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
        autoLottoNumbersGroup.add(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 8)
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