package dto;

import domain.numbers.Numbers;
import java.util.List;

public class LottoNumbersDto {

	private final List<Integer> lottoNumbers;

	public LottoNumbersDto(Numbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers.getNumbers();
	}

	public List<Integer> getLottoNumbers() {
		return List.copyOf(lottoNumbers);
	}
}
