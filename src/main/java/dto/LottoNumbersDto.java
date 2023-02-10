package dto;

import java.util.List;

import domain.LottoNumbers;

public class LottoNumbersDto {

	private final List<Integer> Numbers;

	public LottoNumbersDto(LottoNumbers lottoNumbers) {
		Numbers = lottoNumbers.getNumbers();
	}

	@Override
	public String toString() {
		return Numbers.toString();
	}
}
