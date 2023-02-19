package util.convertor;

public class PurchaseCountConvertor {

    public static Integer convertPurchaseCount(String purchaseCountInput) {
        try {
            Integer purchaseCount = Integer.parseInt(purchaseCountInput);
            validatePositive(purchaseCount);
            return purchaseCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 수동 로또 구매 갯수는 숫자여야 합니다. 다시 입력해주세요");
        }
    }

    private static void validatePositive(Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 수동 로또 구매 갯수는 0개 이상이어야 합니다. 다시 입력해주세요");
        }
    }
}
