package domain;

public class PurchaseAmountConvertor {

	private static final int LOTTO_PURCHASE_AMOUNT_LIMIT = 0;

	public static Integer convertPurchaseAmount(String purchaseAmountMoney) {
		try {
			Integer purchaseAmount = Integer.parseInt(purchaseAmountMoney);
			validatePositive(purchaseAmount);
			return purchaseAmount;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 로또 금액은 숫자여야 합니다. 다시 입력해주세요");
		}
	}

	private static void validatePositive(Integer amount) {
		if (amount < LOTTO_PURCHASE_AMOUNT_LIMIT) {
			throw new IllegalArgumentException("[ERROR] 로또 금액은 0원 이상이어야 합니다. 다시 입력해주세요");
		}
	}
}
