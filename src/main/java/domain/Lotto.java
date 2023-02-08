package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 46;
	private static final int PICK_NUMBERS = 6;
	private final LottoNumbers lottoNumbers;
	private final RandomNumberPicker randomNumberPicker;

	private Lotto(int numberOfLotto) {
		this.randomNumberPicker = new RandomNumberPicker(START_NUMBER, END_NUMBER, PICK_NUMBERS);
		this.lottoNumbers = generateLottoNumbers(numberOfLotto);
	}

	public static Lotto generateLottoWithLottoNumbers(int numberOfLotto) {
		return new Lotto(numberOfLotto);
	}

	private LottoNumbers generateLottoNumbers(int numberOfLotto) {
		List<Numbers> numbersList = new ArrayList<>();
		for (int i = 0; i < numberOfLotto; i++) {
			numbersList.add(randomNumberPicker.pickNumber());
		}
		return new LottoNumbers(numbersList);
	}

	public LottoNumbers getLottoNumbers() {
		return lottoNumbers;
	}
}
