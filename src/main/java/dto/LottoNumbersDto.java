package dto;

import domain.numbers.LottoNumber;
import java.util.List;

public class LottoNumbersDto {

	private final List<Integer> lottoNumbers;

	public LottoNumbersDto(LottoNumber lottoNumber) {
		this.lottoNumbers = lottoNumber.getNumbers();
	}

	public List<Integer> getLottoNumbers() {
		return List.copyOf(lottoNumbers);
	}
}
