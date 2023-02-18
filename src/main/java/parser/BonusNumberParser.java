package parser;

import domain.LottoNumber;

public class BonusNumberParser {
    private static final String BONUS_NUMBER_FORMAT_EXCEPTION_MESSAGE = "보너스 번호는 숫자여야 합니다.";

    public static LottoNumber parse(String input) {
        int bonusNumber = checkInputFormat(input);
        return new LottoNumber(bonusNumber);
    }

    private static int checkInputFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
