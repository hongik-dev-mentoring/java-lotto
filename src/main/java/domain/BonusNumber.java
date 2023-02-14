package domain;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String input) {
        int bonusNumber = checkInputFormat(input);
        checkLottoNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private int checkInputFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }

    private void checkLottoNumberRange(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1에서 45사이의 숫자여야 합니다.");
        }
    }

    public boolean isBonusNumber(int number) {
        return number == bonusNumber;
    }
}
