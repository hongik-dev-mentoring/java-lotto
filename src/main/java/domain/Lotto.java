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
		this.lottoTicket = generateLottoTicket(numberOfLotto);
	}

	private LottoTicket generateLottoTicket(int numberOfLotto) {
		List<LottoNumbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < numberOfLotto; i++) {
			lottoNumbers.add(lottoNumberGenerator.pickNumber());
		}
		return new LottoTicket(lottoNumbers);
	}

	public static Lotto generateLottoWithLottoNumbers(LottoNumberGenerator lottoNumberGenerator, int numberOfLotto) {
		return new Lotto(lottoNumberGenerator, numberOfLotto);
	}

	public LottoTicket getLottoNumbers() {
		return lottoTicket;
	}

	public EnumMap<Ranking, Integer> checkLottoResult(WinningNumbers winningNumbers, BonusBall bonusBall) {
		EnumMap<Ranking, Integer> result = new EnumMap<>(Ranking.class);
		List<LottoNumbers> lottoTicketNumbers = lottoTicket.getLottoTicket();

		for (LottoNumbers lottoNumbers : lottoTicketNumbers) {
			Ranking ranking = calculateRank(lottoNumbers, winningNumbers, bonusBall);
			Optional<Integer> numberOfRank = Optional.ofNullable(result.get(ranking));
			result.put(ranking, numberOfRank.orElse(0) + 1);
		}
		return result;
	}

	private Ranking calculateRank(LottoNumbers lottoNumbers, WinningNumbers winningNumbers, BonusBall bonusBall) {
		List<Integer> pickNumber = winningNumbers.getNumbers();

		long containsNumberCount = pickNumber.stream()
			.filter(lottoNumbers::contains)
			.count();

		return getRanking(containsNumberCount, lottoNumbers, bonusBall);
	}

	private Ranking getRanking(long containsNumberCount, LottoNumbers lottoNumbers, BonusBall bonusBall) {
		Ranking ranking = Ranking.getRanking(Long.valueOf(containsNumberCount).intValue());

		if (isSecondRank(lottoNumbers, bonusBall, ranking)) {
			return Ranking.SECOND;
		}

		return ranking;
	}

	private static boolean isSecondRank(LottoNumbers lottoNumbers, BonusBall bonusBall, Ranking ranking) {
		return ranking == Ranking.THIRD && lottoNumbers.contains(bonusBall.getBonusBallNumber());
	}
}
