package domain;

import java.util.Map;

public class LottoBenefitCalculator {
    public static double calculate(int inputPrice, Map<LottoPrize, Integer> resultMap) {
        int rewardSum = 0;
        for (LottoPrize lottoPrize : resultMap.keySet()) {
            rewardSum += lottoPrize.getReward() * resultMap.get(lottoPrize);
        }
        return Math.floor((double) rewardSum / inputPrice * 100) / 100.0;
    }
}
