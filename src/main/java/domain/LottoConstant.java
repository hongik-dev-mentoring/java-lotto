package domain;

public enum LottoConstant {
    FIRST_PRIZE_KEY("PRIZE_1ST"),
    SECOND_PRIZE_KEY("PRIZE_2ND"),
    THIRD_PRIZE_KEY("PRIZE_3RD"),
    FOURTH_PRIZE_KEY("PRIZE_4TH"),
    FIFTH_PRIZE_KEY("PRIZE_5TH"),
    NO_PRIZE_KEY("NO_PRIZE");

    private final String prizeName;

    LottoConstant(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeName() {
        return prizeName;
    }
}
