package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

public class RankDiscriminator {

	private final WinningNumbers winningNumbers;
	private final BonusBall bonusBall;

	public RankDiscriminator(WinningNumbers winningNumbers, BonusBall bonusBall) {
		this.winningNumbers = winningNumbers;
		this.bonusBall = bonusBall;
	}

	public EnumMap<Rank, Integer> checkLottoResult(LottoTicket lottoTicketNumbers) {
		EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
		List<LottoNumbers> TicketNumbers = lottoTicketNumbers.getLottoTicket();

		for (LottoNumbers lottoNumbers : TicketNumbers) {
			Rank rank = calculateRank(lottoNumbers);
			Optional<Integer> numberOfRank = Optional.ofNullable(result.get(rank));
			result.put(rank, numberOfRank.orElse(0) + 1);
		}
		return result;
	}

	private Rank calculateRank(LottoNumbers lottoNumbers) {
		List<LottoNumber> prizeNumbers = winningNumbers.getNumbers();

		long containsWinningNumberCount = prizeNumbers.stream()
			.filter(lottoNumbers::contains)
			.count();

		return Rank.findRank((int)containsWinningNumberCount, isBonusBallMatch(lottoNumbers));
	}

	private boolean isBonusBallMatch(LottoNumbers lottoNumbers) {
		return lottoNumbers.contains(bonusBall.getLottoNumber());
	}
}
