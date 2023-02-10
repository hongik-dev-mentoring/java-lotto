package domain;

import java.util.*;

public class LottoChecker {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREASE_COUNT = 1;

    private final List<LottoDto> lottoDtoList;
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoChecker(List<LottoDto> lottoDtoList, LottoWinningNumbers lottoWinningNumbers) {
        this.lottoDtoList = new ArrayList<>(lottoDtoList);
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public Map<String, Integer> calculateLottoStatistics() {
        Map<String, Integer> resultMap = initiateResultMap();
        for (LottoDto dto : lottoDtoList) {
            checkLottoWin(resultMap, dto);
        }
        return resultMap;
    }

    private Map<String, Integer> initiateResultMap() {
        Map<String, Integer> resultMap = new TreeMap<>(Comparator.reverseOrder());
        resultMap.put(LottoConstant.FIRST_PRIZE_KEY, INITIAL_COUNT);
        resultMap.put(LottoConstant.SECOND_PRIZE_KEY, INITIAL_COUNT);
        resultMap.put(LottoConstant.THIRD_PRIZE_KEY, INITIAL_COUNT);
        resultMap.put(LottoConstant.FOURTH_PRIZE_KEY, INITIAL_COUNT);
        resultMap.put(LottoConstant.FIFTH_PRIZE_KEY, INITIAL_COUNT);
        return resultMap;
    }

    private void checkLottoWin(Map<String, Integer> resultMap, LottoDto dto) {
        LottoNumberCounter lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
        for (int number : dto.getLottoNumbers()) {
            lottoNumberCounter.countLottoNumbers(number);
            lottoNumberCounter.countBonusNumber(number);
        }
        String mapKey = lottoNumberCounter.decideLottoPrize();
        updateResult(resultMap, mapKey);
    }

    private void updateResult(Map<String, Integer> resultMap, String mapKey) {
        if (mapKey.equals(LottoConstant.NO_PRIZE_KEY)) return;
        resultMap.put(mapKey, resultMap.get(mapKey) + INCREASE_COUNT);
    }

}
