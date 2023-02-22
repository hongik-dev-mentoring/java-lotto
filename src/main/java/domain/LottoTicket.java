package domain;

import java.util.List;

public class LottoTicket {

	private final List<LottoNumbers> lottoTicket;

	public LottoTicket(List<LottoNumbers> lottoTicket) {
		this.lottoTicket = lottoTicket;
	}

	public List<LottoNumbers> getLottoTicket() {
		return lottoTicket;
	}

	public void add(LottoNumbers lottoNumbers) {
		lottoTicket.add(lottoNumbers);
	}
}
