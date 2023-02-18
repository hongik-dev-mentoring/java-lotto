package domain;

import java.util.Arrays;
import java.util.Map;

public enum LottoPrize {
    PRIZE_5TH(3, 5000, false),
    PRIZE_4TH(4, 50000, false),
    PRIZE_3RD(5, 1500000, false),
    PRIZE_2ND(5, 30000000, true),
    PRIZE_1ST(6, 2000000000, false),
    NO_PRIZE(0, 0, false);

    private final int matchingNum;
    private final int reward;
    private final boolean hasBonusNum;

    LottoPrize(int matchingNum, int reward, boolean hasBonusNum) {
        this.matchingNum = matchingNum;
        this.reward = reward;
        this.hasBonusNum = hasBonusNum;
    }

    public int getMatchingNum() {
        return matchingNum;
    }

    public int getReward() {
        return reward;
    }

    public boolean isHasBonusNum() {
        return hasBonusNum;
    }

    public static LottoPrize decideLottoPrize(int count, boolean hasBonusNum) {
        LottoPrize lottoPrize = Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchingNum == count && prize.hasBonusNum == hasBonusNum)
                .findFirst()
                .orElse(NO_PRIZE);
        return lottoPrize;
    }
}
