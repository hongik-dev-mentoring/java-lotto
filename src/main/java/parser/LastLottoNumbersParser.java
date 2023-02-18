package parser;

import domain.LottoNumber;
import domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LastLottoNumbersParser {
    private static final String COMMA_DELIMITER = ",";

    public static LottoNumbers parse(String input) {
        List<LottoNumber> lastLottoNumbers = checkInputFormat(input);
        return new LottoNumbers(lastLottoNumbers);
    }

    private static List<LottoNumber> checkInputFormat(String input) {
        try {
            return Arrays.stream(input.split(COMMA_DELIMITER))
                    .map((number) -> new LottoNumber(Integer.parseInt(number.trim())))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }
    }
}
