package domain;

public class BonusBallConvertor {

	public static LottoNumber convertBonusNumber(String bonusNumber) {
		try {
			return new LottoNumber(Integer.parseInt(bonusNumber));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 한 개의 숫자여야 합니다. 다시 입력해주세요");
		}
	}
}
