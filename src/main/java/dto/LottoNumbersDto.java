package dto;

import domain.numbers.LottoNumbers;
import java.util.List;

public class LottoNumbersDto {

	private final List<Integer> lottoNumbers;

	public LottoNumbersDto(LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers.getNumbers();
	}

	public List<Integer> getLottoNumbers() {
		return List.copyOf(lottoNumbers);
	}
}
