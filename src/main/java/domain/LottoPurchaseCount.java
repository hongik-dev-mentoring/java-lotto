package domain;

public class LottoPurchaseCount {

    private static final int MINIMUM_STOCK = 0;

    final int lottoPurchaseCount;

    public LottoPurchaseCount(int lottoPurchaseCount) {
        this.lottoPurchaseCount = lottoPurchaseCount;
    }

    public LottoPurchaseCount decreaseCount(int count) {
        int result = lottoPurchaseCount - count;
        if (result < MINIMUM_STOCK) {
            throw new IllegalArgumentException("[ERROR] 수동 로또 구매 갯수는 구매 가능 갯수를 넘어갈 수 없습니다.");
        }

        return new LottoPurchaseCount(result);
    }

    public int getLottoPurchaseCount() {
        return lottoPurchaseCount;
    }
}
