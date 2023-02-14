package domain;

import java.util.*;

import static domain.LottoPrize.*;

public class LottoChecker {
    private static final int INITIAL_COUNT = 0;
    private static final int COUNT_UP_UNIT = 1;

    private final List<LottoDto> lottoDtoGroup;
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoChecker(List<LottoDto> lottoDtoGroup, LottoWinningNumbers lottoWinningNumbers) {
        this.lottoDtoGroup = new ArrayList<>(lottoDtoGroup);
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public Map<String, Integer> calculateLottoStatistics() {
        Map<String, Integer> resultMap = initiateResultMap();
        for (LottoDto dto : lottoDtoGroup) {
            checkLottoWin(resultMap, dto);
        }
        return resultMap;
    }

    private Map<String, Integer> initiateResultMap() {
        Map<String, Integer> resultMap = new TreeMap<>(Comparator.reverseOrder());
        resultMap.put(PRIZE_1ST.getPrizeKey(), INITIAL_COUNT);
        resultMap.put(PRIZE_2ND.getPrizeKey(), INITIAL_COUNT);
        resultMap.put(PRIZE_3RD.getPrizeKey(), INITIAL_COUNT);
        resultMap.put(PRIZE_4TH.getPrizeKey(), INITIAL_COUNT);
        resultMap.put(PRIZE_5TH.getPrizeKey(), INITIAL_COUNT);
        return resultMap;
    }

    private void checkLottoWin(Map<String, Integer> resultMap, LottoDto dto) {
        LottoNumberCounter lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
        for (int number : dto.getLottoNumbers()) {
            lottoNumberCounter.countLottoNumbers(number);
        }
        String mapKey = lottoNumberCounter.decideLottoPrize();
        updateResultMap(resultMap, mapKey);
    }

    private void updateResultMap(Map<String, Integer> resultMap, String mapKey) {
        if (mapKey.equals(NO_PRIZE.getPrizeKey())) {
            return;
        }
        resultMap.put(mapKey, resultMap.get(mapKey) + COUNT_UP_UNIT);
    }
}
