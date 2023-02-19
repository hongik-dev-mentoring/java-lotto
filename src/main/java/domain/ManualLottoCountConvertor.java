package domain;

public class ManualLottoCountConvertor {

	public static int convertManualLotto(String bonusNumber) {
		try {
			return Integer.parseInt(bonusNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 수동으로 구매할 로또 번호는 하나의 숫자여야 합니다.");
		}
	}
}
