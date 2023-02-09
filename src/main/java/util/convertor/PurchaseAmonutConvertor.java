package util.convertor;

public class PurchaseAmonutConvertor {

	public static Integer convertPurchaseAmount(String purchaseAmountMoney) {
		try {
			return Integer.parseInt(purchaseAmountMoney);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 로또 금액은 숫자여야 합니다. 다시 입력해주세요");
		}
	}
}
