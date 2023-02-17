package domain;

import java.util.EnumMap;

public class LottoBenefitCalculator {
    public static double calculate(int inputPrice, EnumMap<LottoPrize, Integer> resultMap) {
        int rewardSum = 0;
        for (LottoPrize lottoPrize : resultMap.keySet()) {
            rewardSum += lottoPrize.getReward() * resultMap.get(lottoPrize);
        }
        return Math.floor((double) rewardSum / inputPrice * 100) / 100.0;
    }
}
