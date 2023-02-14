package parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LastLottoNumbersParser {
    public static final String COMMA_DELIMITER = ",";

    public static List<Integer> parse(String input) {
        List<Integer> lastLottoNumbers = checkInputFormat(input);
        checkLottoNumberRange(lastLottoNumbers);
        checkDuplicatedNumber(lastLottoNumbers);
        checkLottoNumbersSize(lastLottoNumbers);
        return lastLottoNumbers;
    }

    private static List<Integer> checkInputFormat(String input) {
        try {
            return Arrays.stream(input.split(COMMA_DELIMITER))
                    .map((number) -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }
    }

    private static void checkLottoNumberRange(List<Integer> lastLottoNumbers) {
        for (int lottoNumber : lastLottoNumbers) {
            handleLottoNumberRangeException(lottoNumber);
        }
    }

    private static void handleLottoNumberRangeException(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    private static void checkDuplicatedNumber(List<Integer> lastLottoNumbers) {
        HashSet<Integer> lottoNumberSet = new HashSet<>(lastLottoNumbers);
        if (lastLottoNumbers.size() != lottoNumberSet.size()) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    private static void checkLottoNumbersSize(List<Integer> lastLottoNumbers) {
        if (lastLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨번호 6개를 다시 입력해주세요.");
        }
    }
}
