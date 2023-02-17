package domain;

import java.util.ArrayList;
import java.util.List;

import util.generator.LottoNumbersGenerator;

public class Lotto {

	private final LottoTicket lottoTicket;
	private final LottoNumbersGenerator lottoNumbersGenerator;
	private static final int LOTTO_NUMBERS_SIZE = 6;

	private Lotto(LottoNumbersGenerator lottoNumbersGenerator, int numberOfLotto) {
		this.lottoNumbersGenerator = lottoNumbersGenerator;
		this.lottoTicket = generateLottoTicket(numberOfLotto);
	}

	public static Lotto generateLottoWithLottoNumbers(LottoNumbersGenerator lottoNumbersGenerator, int numberOfLotto) {
		return new Lotto(lottoNumbersGenerator, numberOfLotto);
	}

	private LottoTicket generateLottoTicket(int numberOfLotto) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < numberOfLotto; i++) {
			lottoNumbers.add(lottoNumbersGenerator.generateLottoNumbers(LOTTO_NUMBERS_SIZE));
		}
		return new LottoTicket(lottoNumbers);
	}

	public LottoTicket getLottoTicketNumbers() {
		return lottoTicket;
	}
}
