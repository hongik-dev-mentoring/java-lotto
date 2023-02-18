package view;

import java.util.List;

public class InputException {

    public static void handleMinimum(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException();
        }
    }

    public static void handleLottoNumberRange(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("1에서 45사이의 숫자를 입력해주세요.");
        }
    }

    public static void handleDuplicate(List<Integer> lastLottoNumbers, int input) {
        if (lastLottoNumbers.contains(input)) {
            throw new IllegalArgumentException("중복된 번호입니다. 다시입력해주세요.");
        }
    }

    public static void handleLottoNumbersSize(List<Integer> lastLottoNumbers) {
        if (lastLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨번호 6개를 다시 입력해주세요.");
        }
    }

    public static int handleInputFormat(String component) {
        try {
            return Integer.parseInt(component);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
