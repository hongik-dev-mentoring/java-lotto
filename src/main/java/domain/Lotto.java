package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	private final LottoTicket lottoTicket;
	private final LottoNumberGenerator lottoNumberGenerator;

	private Lotto(LottoNumberGenerator lottoNumberGenerator, int numberOfLotto) {
		this.lottoNumberGenerator = lottoNumberGenerator;
		this.lottoTicket = generateLottoTicket(numberOfLotto);
	}

	public static Lotto generateLottoWithLottoNumbers(LottoNumberGenerator lottoNumberGenerator, int numberOfLotto) {
		return new Lotto(lottoNumberGenerator, numberOfLotto);
	}

	private LottoTicket generateLottoTicket(int numberOfLotto) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < numberOfLotto; i++) {
			lottoNumbers.add(lottoNumberGenerator.generateLottoNumbers());
		}
		return new LottoTicket(lottoNumbers);
	}

	public LottoTicket getLottoTicketNumbers() {
		return lottoTicket;
	}
}
