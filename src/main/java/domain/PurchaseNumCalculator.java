package domain;

public class PurchaseNumCalculator {
    private static final int LOTTO_PRICE = 1000;

    public static int calculateLotto(int inputPrice) {
        return inputPrice / LOTTO_PRICE;
    }
}
