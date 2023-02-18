package domain;

import java.util.ArrayList;
import java.util.List;

import util.generator.RandomLottoNumbersGenerator;

public class Lotto {

	private final LottoTicket lottoTicket;
	private final RandomLottoNumbersGenerator randomLottoNumbersGenerator;
	private static final int LOTTO_NUMBERS_SIZE = 6;

	private Lotto(RandomLottoNumbersGenerator randomLottoNumbersGenerator, int numberOfLotto) {
		this.randomLottoNumbersGenerator = randomLottoNumbersGenerator;
		this.lottoTicket = generateLottoTicket(numberOfLotto);
	}

	public static Lotto generateLottoWithLottoNumbers(RandomLottoNumbersGenerator randomLottoNumbersGenerator, int numberOfLotto) {
		return new Lotto(randomLottoNumbersGenerator, numberOfLotto);
	}

	private LottoTicket generateLottoTicket(int numberOfLotto) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < numberOfLotto; i++) {
			lottoNumbers.add(randomLottoNumbersGenerator.generateLottoNumbers(LOTTO_NUMBERS_SIZE));
		}
		return new LottoTicket(lottoNumbers);
	}

	public LottoTicket getLottoTicketNumbers() {
		return lottoTicket;
	}
}
