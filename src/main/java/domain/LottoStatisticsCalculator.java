package domain;

import java.util.*;

import static domain.LottoPrize.*;

public class LottoStatisticsCalculator {
    private static final int INITIAL_COUNT = 0;
    private static final int COUNT_UP_UNIT = 1;

    private final List<LottoDto> lottoDtoGroup;
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoStatisticsCalculator(List<LottoDto> lottoDtoGroup, LottoWinningNumbers lottoWinningNumbers) {
        this.lottoDtoGroup = new ArrayList<>(lottoDtoGroup);
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public Map<LottoPrize, Integer> calculate() {
        Map<LottoPrize, Integer> resultMap = initiateResultMap();
        for (LottoDto dto : lottoDtoGroup) {
            checkLottoWin(resultMap, dto);
        }
        return resultMap;
    }

    private Map<LottoPrize, Integer> initiateResultMap() {
        Map<LottoPrize, Integer> resultMap = new HashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            resultMap.put(lottoPrize, INITIAL_COUNT);
        }
        return resultMap;
    }

    private void checkLottoWin(Map<LottoPrize, Integer> resultMap, LottoDto dto) {
        LottoNumberCounter lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
        LottoPrize key = lottoNumberCounter.decideLottoPrize(dto);
        countLottoPrize(resultMap, key);
    }

    private void countLottoPrize(Map<LottoPrize, Integer> resultMap, LottoPrize key) {
        if (key.equals(NO_PRIZE)) {
            return;
        }
        resultMap.put(key, resultMap.get(key) + COUNT_UP_UNIT);
    }
}
