package domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

public class Lotto {

	private final LottoNumbers lottoNumbers;
	private final RandomNumberPicker randomNumberPicker;

	private Lotto(RandomNumberPicker randomNumberPicker, int numberOfLotto) {
		this.randomNumberPicker = randomNumberPicker;
		this.lottoNumbers = generateLottoNumbers(numberOfLotto);
	}

	public static Lotto generateLottoWithLottoNumbers(RandomNumberPicker randomNumberPicker, int numberOfLotto) {
		return new Lotto(randomNumberPicker, numberOfLotto);
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

	public EnumMap<Ranking, Integer> checkLottoResult(Numbers pickNumbers, Integer bonusBall) {
		EnumMap<Ranking, Integer> result = new EnumMap<>(Ranking.class);
		List<Numbers> RandomNumberList = lottoNumbers.getNumbers();

		for (Numbers lottoNumbersRow : RandomNumberList) {
			Ranking ranking = checkRank(lottoNumbersRow, pickNumbers, bonusBall);
			Optional<Integer> numberOfRank = Optional.ofNullable(result.get(ranking));
			result.put(ranking, numberOfRank.orElse(0) + 1);
		}
		return result;
	}

	private Ranking checkRank(Numbers lottoNumbers, Numbers pickNumbers, Integer bonusBall) {
		List<Integer> pickNumber = pickNumbers.getNumbers();

		long containsNumberCount = pickNumber.stream()
			.filter(lottoNumbers::contains)
			.count();

		Ranking ranking = Ranking.getRanking(Long.valueOf(containsNumberCount).intValue());

		if (ranking != Ranking.THIRD) {
			return ranking;
		}

		if (lottoNumbers.contains(bonusBall)) {
			return Ranking.SECOND;
		}

		return Ranking.THIRD;
	}
}
