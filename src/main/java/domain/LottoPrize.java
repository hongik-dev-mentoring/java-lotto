package domain;

public enum LottoPrize {
    FIFTH_PRIZE("PRIZE_5TH", "3개 일치 (5000원)", 5000),
    FOURTH_PRIZE("PRIZE_4TH", "4개 일치 (50000원)", 50000),
    THIRD_PRIZE("PRIZE_3RD", "5개 일치 (1500000원)", 1500000),
    SECOND_PRIZE("PRIZE_2ND", "5개 일치, 보너스 볼 일치(30000000원)", 30000000),
    FIRST_PRIZE("PRIZE_1ST", "6개 일치 (2000000000원)", 2000000000),
    NO_PRIZE("NO_PRIZE", "꽝", 0);

    private final String prizeKey;
    private final String prizeText;
    private final int reward;

    LottoPrize(String prizeKey, String prizeText, int reward) {
        this.prizeKey = prizeKey;
        this.prizeText = prizeText;
        this.reward = reward;
    }

    public String getPrizeKey() {
        return prizeKey;
    }

    public String getPrizeText() {
        return prizeText;
    }

    public int getReward() {
        return reward;
    }
}
