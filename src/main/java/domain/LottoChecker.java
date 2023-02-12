package domain;

import java.util.*;

public class LottoChecker {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREASE_COUNT = 1;
    private static final int LOTTO_PRICE = 1000;

    private final List<LottoNumbers> lottoNumbersGroup;
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoChecker(List<LottoNumbers> lottoNumbersGroup, LottoWinningNumbers lottoWinningNumbers) {
        this.lottoNumbersGroup = new ArrayList<>(lottoNumbersGroup);
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public Map<String, Integer> calculateLottoStatistics() {
        Map<String, Integer> calculateResult = initiateResultMap();
        for (LottoNumbers dto : lottoNumbersGroup) {
            checkLottoWin(calculateResult, dto);
        }
        return calculateResult;
    }

    private Map<String, Integer> initiateResultMap() {
        Map<String, Integer> calculateResult = new TreeMap<>(Comparator.reverseOrder());
        calculateResult.put(LottoConstant.FIRST_PRIZE_KEY.getPrizeName(), INITIAL_COUNT);
        calculateResult.put(LottoConstant.SECOND_PRIZE_KEY.getPrizeName(), INITIAL_COUNT);
        calculateResult.put(LottoConstant.THIRD_PRIZE_KEY.getPrizeName(), INITIAL_COUNT);
        calculateResult.put(LottoConstant.FOURTH_PRIZE_KEY.getPrizeName(), INITIAL_COUNT);
        calculateResult.put(LottoConstant.FIFTH_PRIZE_KEY.getPrizeName(), INITIAL_COUNT);
        return calculateResult;
    }

    private void checkLottoWin(Map<String, Integer> calculateResult, LottoNumbers dto) {
        LottoNumberCounter lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
        for (int number : dto.getLottoNumbers()) {
            lottoNumberCounter.countLottoNumbers(number);
            lottoNumberCounter.countBonusNumber(number);
        }
        String mapKey = lottoNumberCounter.decideLottoPrize();
        updateResult(calculateResult, mapKey);
    }

    private void updateResult(Map<String, Integer> calculateResult, String mapKey) {
        if (mapKey.equals(LottoConstant.NO_PRIZE_KEY.getPrizeName())) {
            return;
        }
        calculateResult.put(mapKey, calculateResult.get(mapKey) + INCREASE_COUNT);
    }

    public double getBenefit(Map<String, Integer> statisticsMap) {
        int rewardSum = 0;
        for (Map.Entry<String, Integer> lottoEntry : statisticsMap.entrySet()) {
            LottoEnum lottoEnum = LottoEnum.valueOf(lottoEntry.getKey());
            rewardSum += lottoEnum.getReward() * lottoEntry.getValue();
        }
        return (double) rewardSum / LOTTO_PRICE;
    }


}
