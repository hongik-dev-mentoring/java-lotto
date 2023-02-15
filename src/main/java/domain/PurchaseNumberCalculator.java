package domain;

public class PurchaseNumberCalculator {
    private static final int LOTTO_PRICE = 1000;

    public static int calculate(int inputPrice) {
        return inputPrice / LOTTO_PRICE;
    }
}
