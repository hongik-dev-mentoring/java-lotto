package domain;

import domain.numbers.LottoNumberGenerator;
import domain.numbers.LottoNumber;
import domain.numbers.WinningNumber;
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
        List<LottoNumber> lottoNumbers = new ArrayList<>(manualLottoTicket.getLottoNumbers());
        for (int i = 0; i < numberOfLotto; i++) {
            lottoNumbers.add(lottoNumberGenerator.pickNumber());
        }
        return new LottoTicket(lottoNumbers);
    }

    public static Lotto generateLottoWithManualLottoTicket(LottoNumberGenerator lottoNumberGenerator,
        int numberOfLotto, LottoTicket manualLottoTicket) {
        return new Lotto(lottoNumberGenerator, numberOfLotto, manualLottoTicket);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public EnumMap<Ranking, Integer> checkLottoResult(WinningNumber winningNumber) {
        EnumMap<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        List<LottoNumber> lottoTicketNumbers = lottoTicket.getLottoNumbers();

        for (LottoNumber lottoNumber : lottoTicketNumbers) {
            Ranking ranking = checkRank(lottoNumber, winningNumber);
            Optional<Integer> numberOfRank = Optional.ofNullable(result.get(ranking));
            result.put(ranking, numberOfRank.orElse(0) + 1);
        }
        return result;
    }

    private Ranking checkRank(LottoNumber lottoNumber, WinningNumber winningNumber) {
        List<Integer> pickNumber = winningNumber.getNumbers();

        long containsNumberCount = pickNumber.stream()
            .filter(lottoNumber::contains)
            .count();

        return getRanking(containsNumberCount, lottoNumber, winningNumber.getBonusBallNumber());
    }

    private Ranking getRanking(long containsNumberCount, LottoNumber lottoNumber, int bonusBallNumber) {
        Ranking ranking = Ranking.getRanking(Long.valueOf(containsNumberCount).intValue());

        if (ranking == Ranking.SECOND || ranking == Ranking.THIRD) {
            return checkRankingSecondOrThird(lottoNumber, bonusBallNumber);
        }

        return ranking;
    }

    private Ranking checkRankingSecondOrThird(LottoNumber lottoNumber, int bonusBall) {
        if (lottoNumber.contains(bonusBall)) {
            return Ranking.SECOND;
        }

        return Ranking.THIRD;
    }
}
