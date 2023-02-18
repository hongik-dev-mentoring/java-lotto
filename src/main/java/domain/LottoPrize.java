package domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoPrize {
    PRIZE_5TH(3, 5000),
    PRIZE_4TH(4, 50000),
    PRIZE_3RD(5, 1500000),
    PRIZE_2ND(5, 30000000),
    PRIZE_1ST(6, 2000000000),
    NO_PRIZE(0, 0);

    private final int count;
    private final int reward;

    LottoPrize(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public static List<LottoPrize> getSortedLottoPrizes() {
        return Arrays.stream(LottoPrize.values())
                .filter((prize) -> prize != NO_PRIZE)
                .sorted(Comparator.comparing(LottoPrize::getReward))
                .collect(Collectors.toList());
    }

    public static LottoPrize selectLottoPrize(int count, boolean hasBonus) {
        if (count == 5 && hasBonus) {
            return PRIZE_2ND;
        }
        List<LottoPrize> selectedLottoPrize = findLottoPrizeUsingCount(count);
        if (selectedLottoPrize.isEmpty()) {
            return NO_PRIZE;
        }
        return selectedLottoPrize.get(0);
    }

    private static List<LottoPrize> findLottoPrizeUsingCount(int count) {
        return LottoPrize.getNoBonusLottoPrizes()
                .stream()
                .filter(prize -> prize.count == count)
                .collect(Collectors.toList());
    }

    private static List<LottoPrize> getNoBonusLottoPrizes() {
        return Arrays.stream(LottoPrize.values())
                .filter((prize) -> prize != PRIZE_2ND)
                .collect(Collectors.toList());
    }

    public int getCount() {
        return count;
    }

    public int getReward() {
        return reward;
    }
}
