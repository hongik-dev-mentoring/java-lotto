package dto;

import domain.numbers.Numbers;
import java.util.List;

public class LottoNumbersDto {

	private final List<Integer> Numbers;

	public LottoNumbersDto(Numbers lottoNumbers) {
		Numbers = lottoNumbers.getNumbers();
	}

	@Override
	public String toString() {
		return Numbers.toString();
	}
}
