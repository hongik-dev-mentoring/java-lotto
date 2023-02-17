package domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoPrize {
    PRIZE_5TH(3, false, 5000),
    PRIZE_4TH(4, false, 50000),
    PRIZE_3RD(5, false, 1500000),
    PRIZE_2ND(5, true, 30000000),
    PRIZE_1ST(6, false, 2000000000),
    NO_PRIZE(0, false, 0);

    private final int count;
    private final boolean hasBonus;
    private final int reward;

    LottoPrize(int count, boolean hasBonus, int reward) {
        this.count = count;
        this.hasBonus = hasBonus;
        this.reward = reward;
    }

    public static List<LottoPrize> getSortedLottoPrizes() {
        return Arrays.stream(LottoPrize.values())
                .filter((prize) -> prize != NO_PRIZE)
                .sorted(Comparator.comparing(LottoPrize::getReward))
                .collect(Collectors.toList());
    }

    public static LottoPrize selectLottoPrize(int count, boolean hasBonus) {
        List<LottoPrize> lottoPrizes = Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.count == count && prize.hasBonus == hasBonus)
                .collect(Collectors.toList());

        if (lottoPrizes.isEmpty()) {
            return NO_PRIZE;
        }
        return lottoPrizes.get(0);
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }
}
