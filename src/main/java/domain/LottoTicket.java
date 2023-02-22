package domain;

import domain.numbers.LottoNumber;
import java.util.List;

public class LottoTicket {

	private final List<LottoNumber> lottoTicket;

	public LottoTicket(List<LottoNumber> lottoTicket) {
		this.lottoTicket = lottoTicket;
	}

	public List<LottoNumber> getLottoNumbers() {
		return List.copyOf(lottoTicket);
	}
}
