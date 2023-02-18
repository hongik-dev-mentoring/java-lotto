package domain;

public class PurchaseNumberCalculator {
    private static final int LOTTO_PRICE = 1000;

    public static int calculateTotalPurchaseNumber(int inputPrice) {
        return inputPrice / LOTTO_PRICE;
    }

    public static int calculateAutoPurchaseNumber(int totalPurchaseNumber, int manualPurchaseNumber) {
        return totalPurchaseNumber - manualPurchaseNumber;
    }
}
