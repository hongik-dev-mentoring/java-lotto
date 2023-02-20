package domain;

import java.util.ArrayList;

public class Lotto {

	private static final int LOTTO_NUMBERS_SIZE = 6;

	private final LottoTicket lottoTicket;
	private final NumbersGenerator numbersGenerator;

	public Lotto(NumbersGenerator numbersGenerator) {
		this.numbersGenerator = numbersGenerator;
		this.lottoTicket = new LottoTicket(new ArrayList<>());
	}

	public void generateLottoTicket() {
		lottoTicket.add(numbersGenerator.generateLottoNumbers(LOTTO_NUMBERS_SIZE));
	}

	public LottoTicket getLottoTicketNumbers() {
		return lottoTicket;
	}
}
