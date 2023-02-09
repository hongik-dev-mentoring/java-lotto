package domain;

import java.util.List;

public class LottoTicket {

	private final List<Numbers> lottoTicket;

	public LottoTicket(List<Numbers> lottoTicket) {
		this.lottoTicket = lottoTicket;
	}

	public List<Numbers> getLottoTicket() {
		return List.copyOf(lottoTicket);
	}
}
