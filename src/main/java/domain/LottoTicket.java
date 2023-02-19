package domain;

import domain.numbers.LottoNumbers;
import java.util.List;

public class LottoTicket {

	private final List<LottoNumbers> lottoTicket;

	public LottoTicket(List<LottoNumbers> lottoTicket) {
		this.lottoTicket = lottoTicket;
	}

	public List<LottoNumbers> getLottoTicket() {
		return List.copyOf(lottoTicket);
	}
}
