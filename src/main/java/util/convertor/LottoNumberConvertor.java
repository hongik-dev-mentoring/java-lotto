package util.convertor;

import domain.numbers.LottoNumber;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberConvertor {

	private static final String DELIMITER = ",";

	public static LottoNumber convertLottoNumbers(String lottoNumberInput) {
		try {
			String[] split = lottoNumberInput.split(DELIMITER);
			List<Integer> lottoNumbers = Arrays.stream(split)
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList());

			return new LottoNumber(lottoNumbers);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로만 구성 되어야 합니다. 다시 입력해주세요");
		}
	}

	public static Integer convertBonusNumber(String bonusNumber) {
		try {
			return Integer.parseInt(bonusNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 한 개의 숫자여야 합니다. 다시 입력해주세요");
		}
	}
}
