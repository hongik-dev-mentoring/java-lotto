package domain;

import java.util.*;

public class LottoChecker {
    private static final int INCREASE_COUNT = 1;
    private static final int INITIAL_COUNT = 0;

    private final List<LottoNumbers> lottoNumbersGroup;
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoChecker(List<LottoNumbers> lottoNumbersGroup, LottoWinningNumbers lottoWinningNumbers) {
        this.lottoNumbersGroup = new ArrayList<>(lottoNumbersGroup);
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public Map<LottoPrize, Integer> calculateLottoStatistics() {
        Map<LottoPrize, Integer> calculateResult = initiateResultMap();
        for (LottoNumbers lottoNumbers : lottoNumbersGroup) {
            checkLottoWin(calculateResult, lottoNumbers);
        }
        return calculateResult;
    }

    private Map<LottoPrize, Integer> initiateResultMap() {
        Map<LottoPrize, Integer> calculateResult = new EnumMap<>(LottoPrize.class);
        calculateResult.put(LottoPrize.PRIZE_1ST,INITIAL_COUNT);
        calculateResult.put(LottoPrize.PRIZE_2ND,INITIAL_COUNT);
        calculateResult.put(LottoPrize.PRIZE_3RD,INITIAL_COUNT);
        calculateResult.put(LottoPrize.PRIZE_4TH,INITIAL_COUNT);
        calculateResult.put(LottoPrize.PRIZE_5TH,INITIAL_COUNT);
        return calculateResult;
    }

    private void checkLottoWin(Map<LottoPrize, Integer> calculateResult, LottoNumbers lottoNumbers) {
        LottoNumberCounter lottoNumberCounter = new LottoNumberCounter(lottoWinningNumbers);
        for (int number : lottoNumbers.getLottoNumbers()) {
            lottoNumberCounter.countLottoNumbers(number);
            lottoNumberCounter.countBonusNumber(number);
        }
        LottoPrize mapKey = lottoNumberCounter.decideLottoPrize();
        updateResult(calculateResult, mapKey);
    }

    private void updateResult(Map<LottoPrize, Integer> calculateResult, LottoPrize mapKey) {
        if (mapKey.equals(LottoPrize.NO_PRIZE)) {
            return;
        }
        calculateResult.put(mapKey, calculateResult.get(mapKey) + INCREASE_COUNT);
    }

    public double getBenefit(Map<LottoPrize, Integer> statisticsMap, int inputPrice) {
        int rewardSum = 0;
        for (Map.Entry<LottoPrize, Integer> lottoEntry : statisticsMap.entrySet()) {
            LottoPrize lottoPrize = lottoEntry.getKey();
            rewardSum += lottoPrize.getReward() * lottoEntry.getValue();
        }
        return (double) rewardSum / inputPrice;
    }
}
