package dto;

import java.util.List;
import java.util.stream.Collectors;

import domain.LottoTicket;

public class LottoTicketDto {

	List<LottoNumbersDto> lottoNumbers;

	public LottoTicketDto(LottoTicket lottoTicket) {
		this.lottoNumbers = lottoTicket.getLottoNumbers()
			.stream()
			.map(LottoNumbersDto::new)
			.collect(Collectors.toList());
	}

	public List<LottoNumbersDto> getLottoNumbersDto() {
		return List.copyOf(lottoNumbers);
	}
}
