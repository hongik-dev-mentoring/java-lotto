package domain;

import domain.numbers.LottoNumbers;
import domain.numbers.Numbers;
import domain.numbers.WinningNumbers;
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
        List<Numbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoNumbers.add(lottoNumberGenerator.pickNumber());
        }
        return new LottoTicket(lottoNumbers);
    }

    public static Lotto generateLottoWithLottoNumbers(LottoNumberGenerator lottoNumberGenerator,
        int numberOfLotto) {
        return new Lotto(lottoNumberGenerator, numberOfLotto);
    }

    public LottoTicket getLottoNumbers() {
        return lottoTicket;
    }

    public EnumMap<Ranking, Integer> checkLottoResult(WinningNumbers winningNumbers,
        BonusBall bonusBall) {
        EnumMap<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        List<Numbers> lottoTicketNumbers = lottoTicket.getLottoTicket();

        for (Numbers lottoNumbers : lottoTicketNumbers) {
            Ranking ranking = checkRank((LottoNumbers) lottoNumbers, winningNumbers, bonusBall);
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

    private Ranking getRanking(long containsNumberCount, Numbers lottoNumbers, BonusBall bonusBall) {
        Ranking ranking = Ranking.getRanking(Long.valueOf(containsNumberCount).intValue());

        if (ranking == Ranking.SECOND || ranking == Ranking.THIRD) {
            return checkRankingSecondOrThird(lottoNumbers, bonusBall);
        }

        return ranking;
    }

    private Ranking checkRankingSecondOrThird(Numbers lottoNumbers, BonusBall bonusBall) {
        if (lottoNumbers.contains(bonusBall.getBonusBallNumber())) {
            return Ranking.SECOND;
        }

        return Ranking.THIRD;
    }
}
