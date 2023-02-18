package parser;

import domain.LottoNumber;
import domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbersParser {
    private static final String LOTTO_NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또 번호는 숫자여야 합니다.";
    private static final String COMMA_DELIMITER = ",";

    public static List<LottoNumbers> parse(List<String> manualLottoNumbers) {
        return parseToLottoNumbersGroup(manualLottoNumbers);
    }

    private static List<LottoNumbers> parseToLottoNumbersGroup(List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(ManualLottoNumbersParser::parseToLottoNumberList)
                .map(LottoNumbers::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> parseToLottoNumberList(String input) {
        try {
            return Arrays.stream(input.split(COMMA_DELIMITER))
                    .map((number) -> new LottoNumber(Integer.parseInt(number.trim())))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
