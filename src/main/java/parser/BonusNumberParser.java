package parser;

import domain.LottoNumber;

public class BonusNumberParser {

    public static LottoNumber parse(String input) {
        int bonusNumber = checkInputFormat(input);
        return new LottoNumber(bonusNumber);
    }

    private static int checkInputFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }
}
