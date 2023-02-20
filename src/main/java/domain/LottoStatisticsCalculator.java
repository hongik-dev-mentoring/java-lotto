package domain;

import java.util.*;

import static domain.LottoPrize.*;

public class LottoStatisticsCalculator {
    private static final int INITIAL_COUNT = 0;
    private static final int COUNT_UP_UNIT = 1;

    private final LottoTicket lottoTicket;
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoStatisticsCalculator(LottoTicket lottoTicket, LottoWinningNumbers lottoWinningNumbers) {
        this.lottoTicket = lottoTicket;
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public EnumMap<LottoPrize, Integer> calculate() {
        EnumMap<LottoPrize, Integer> resultMap = initiateResultMap();
        for (LottoNumbers lottoNumbers : lottoTicket.getLottoNumbersGroup()) {
            checkLottoWin(resultMap, lottoNumbers);
        }
        return resultMap;
    }

    private EnumMap<LottoPrize, Integer> initiateResultMap() {
        EnumMap<LottoPrize, Integer> resultMap = new EnumMap<>(LottoPrize.class);
        for (LottoPrize lottoPrize : LottoPrize.getSortedLottoPrizes()) {
            resultMap.put(lottoPrize, INITIAL_COUNT);
        }
        return resultMap;
    }

    private void checkLottoWin(EnumMap<LottoPrize, Integer> resultMap, LottoNumbers lottoNumbers) {
        LottoNumberCounter lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
        LottoPrize key = lottoNumberCounter.decideLottoPrize(lottoNumbers);
        countLottoPrize(resultMap, key);
    }

    private void countLottoPrize(EnumMap<LottoPrize, Integer> resultMap, LottoPrize key) {
        if (key.equals(NO_PRIZE)) {
            return;
        }
        resultMap.put(key, resultMap.get(key) + COUNT_UP_UNIT);
    }
}
