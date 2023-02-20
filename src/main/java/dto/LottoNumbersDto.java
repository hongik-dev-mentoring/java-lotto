package dto;

import java.util.List;
import java.util.stream.Collectors;

import domain.LottoNumbers;

public class LottoNumbersDto {

	private final List<LottoNumberDto> numbers;

	public LottoNumbersDto(LottoNumbers lottoNumbers) {
		numbers = lottoNumbers.getNumbers()
			.stream()
			.map(LottoNumberDto::new)
			.collect(Collectors.toList());
	}

	public List<LottoNumberDto> getNumbers() {
		return numbers;
	}
}
