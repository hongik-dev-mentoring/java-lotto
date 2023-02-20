package dto;

import domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDto {
    private final List<LottoNumbersDto> lottoNumbersGroup;

    public LottoTicketDto(LottoTicket lottoTicket) {
        this.lottoNumbersGroup = lottoTicket.getLottoNumbersGroup()
                .stream()
                .map(LottoNumbersDto::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumbersDto> getLottoNumbersGroup() {
        return lottoNumbersGroup;
    }
}
