package parser;

public class BonusNumberParser {

    public static int parse(String input) {
        int bonusNumber = checkInputFormat(input);
        checkLottoNumberRange(bonusNumber);
        return bonusNumber;
    }

    private static int checkInputFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }

    private static void checkLottoNumberRange(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45사이의 숫자여야 합니다.");
        }
    }
}
