package domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

public class Lotto {

	private final LottoTicket lottoTicket;
	private final LottoNumberGenerator lottoNumberGenerator;

	private Lotto(LottoNumberGenerator lottoNumberGenerator, int numberOfLotto) {
		this.lottoNumberGenerator = lottoNumberGenerator;
		this.lottoTicket = generateLottoNumbers(numberOfLotto);
	}

	public static Lotto generateLottoWithLottoNumbers(LottoNumberGenerator lottoNumberGenerator, int numberOfLotto) {
		return new Lotto(lottoNumberGenerator, numberOfLotto);
	}

	private LottoTicket generateLottoNumbers(int numberOfLotto) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < numberOfLotto; i++) {
			lottoNumbers.add(lottoNumberGenerator.pickNumber());
		}
		return new LottoTicket(lottoNumbers);
	}

	public LottoTicket getLottoNumbers() {
		return lottoTicket;
	}

	public EnumMap<Ranking, Integer> checkLottoResult(LottoNumbers pickLottoNumbers, Integer bonusBall) {
		EnumMap<Ranking, Integer> result = new EnumMap<>(Ranking.class);
		List<LottoNumbers> lottoNumbers = lottoTicket.getLottoTicket();

		for (LottoNumbers lottoLottoNumbersRow : lottoNumbers) {
			Ranking ranking = checkRank(lottoLottoNumbersRow, pickLottoNumbers, bonusBall);
			Optional<Integer> numberOfRank = Optional.ofNullable(result.get(ranking));
			result.put(ranking, numberOfRank.orElse(0) + 1);
		}
		return result;
	}

	private Ranking checkRank(LottoNumbers lottoNumbers, LottoNumbers pickLottoNumbers, Integer bonusBall) {
		List<Integer> pickNumber = pickLottoNumbers.getNumbers();

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
