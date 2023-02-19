package domain;

import domain.numbers.LottoNumbers;
import domain.numbers.WinningNumbers;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

public class Lotto {

    private final LottoTicket lottoTicket;
    private final LottoNumberGenerator lottoNumberGenerator;

    private Lotto(LottoNumberGenerator lottoNumberGenerator, int numberOfLotto, LottoTicket manualLottoTicket) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottoTicket = generateLottoTicket(numberOfLotto, manualLottoTicket);
    }

    private LottoTicket generateLottoTicket(int numberOfLotto, LottoTicket manualLottoTicket) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>(manualLottoTicket.getLottoTicket());
        for (int i = 0; i < numberOfLotto; i++) {
            lottoNumbers.add(lottoNumberGenerator.pickNumber());
        }
        return new LottoTicket(lottoNumbers);
    }

    public static Lotto generateLottoWithManualLottoTicket(LottoNumberGenerator lottoNumberGenerator,
        int numberOfLotto, LottoTicket manualLottoTicket) {
        return new Lotto(lottoNumberGenerator, numberOfLotto, manualLottoTicket);
    }

    public LottoTicket getLottoNumbers() {
        return lottoTicket;
    }

    public EnumMap<Ranking, Integer> checkLottoResult(WinningNumbers winningNumbers, BonusBall bonusBall) {
        EnumMap<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        List<LottoNumbers> lottoTicketNumbers = lottoTicket.getLottoTicket();

        for (LottoNumbers lottoNumbers : lottoTicketNumbers) {
            Ranking ranking = checkRank(lottoNumbers, winningNumbers, bonusBall);
            Optional<Integer> numberOfRank = Optional.ofNullable(result.get(ranking));
            result.put(ranking, numberOfRank.orElse(0) + 1);
        }
        return result;
    }

    private Ranking checkRank(LottoNumbers lottoNumbers, WinningNumbers winningNumbers,
        BonusBall bonusBall) {
        List<Integer> pickNumber = winningNumbers.getNumbers();

        long containsNumberCount = pickNumber.stream()
            .filter(lottoNumbers::contains)
            .count();

        return getRanking(containsNumberCount, lottoNumbers, bonusBall);
    }

    private Ranking getRanking(long containsNumberCount, LottoNumbers lottoNumbers, BonusBall bonusBall) {
        Ranking ranking = Ranking.getRanking(Long.valueOf(containsNumberCount).intValue());

        if (ranking == Ranking.SECOND || ranking == Ranking.THIRD) {
            return checkRankingSecondOrThird(lottoNumbers, bonusBall);
        }

        return ranking;
    }

    private Ranking checkRankingSecondOrThird(LottoNumbers lottoNumbers, BonusBall bonusBall) {
        if (lottoNumbers.contains(bonusBall.getBonusBallNumber())) {
            return Ranking.SECOND;
        }

        return Ranking.THIRD;
    }
}
