package domain;

public enum LottoEnum {
    PRIZE_5TH("3개 일치 (5000원)", 5000),
    PRIZE_4TH("4개 일치 (50000원)", 50000),
    PRIZE_3RD("5개 일치 (1500000원)", 1500000),
    PRIZE_2ND("5개 일치, 보너스 볼 일치(30000000원)", 30000000),
    PRIZE_1ST("6개 일치 (2000000000원)", 2000000000);

    private final String prizeText;
    private final int reward;

    LottoEnum(String prizeText, int reward) {
        this.prizeText = prizeText;
        this.reward = reward;
    }

    public String getPrizeText() {
        return prizeText;
    }

    public int getReward() {
        return reward;
    }
}
