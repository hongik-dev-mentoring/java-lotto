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
        Map<String, Integer> calculateResult = initiateResultMap();
        for (LottoDto dto : lottoDtoList) {
            checkLottoWin(calculateResult, dto);
        }
        return calculateResult;
    }

    private Map<String, Integer> initiateResultMap() {
        Map<String, Integer> calculateResult = new TreeMap<>(Comparator.reverseOrder());
        calculateResult.put(LottoConstant.FIRST_PRIZE_KEY, INITIAL_COUNT);
        calculateResult.put(LottoConstant.SECOND_PRIZE_KEY, INITIAL_COUNT);
        calculateResult.put(LottoConstant.THIRD_PRIZE_KEY, INITIAL_COUNT);
        calculateResult.put(LottoConstant.FOURTH_PRIZE_KEY, INITIAL_COUNT);
        calculateResult.put(LottoConstant.FIFTH_PRIZE_KEY, INITIAL_COUNT);
        return calculateResult;
    }

    private void checkLottoWin(Map<String, Integer> calculateResult, LottoDto dto) {
        LottoNumberCounter lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
        for (int number : dto.getLottoNumbers()) {
            lottoNumberCounter.countLottoNumbers(number);
            lottoNumberCounter.countBonusNumber(number);
        }
        String mapKey = lottoNumberCounter.decideLottoPrize();
        updateResult(calculateResult, mapKey);
    }

    public void updateResult(Map<String, Integer> calculateResult, String mapKey) {
        if (mapKey.equals(LottoConstant.NO_PRIZE_KEY)) return;
        calculateResult.put(mapKey, calculateResult.get(mapKey) + INCREASE_COUNT);
    }
}
