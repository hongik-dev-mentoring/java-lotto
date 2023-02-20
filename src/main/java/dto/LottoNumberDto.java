package dto;

import domain.LottoNumber;

public class LottoNumberDto {

	private final LottoNumber lottoNumber;

	public LottoNumberDto(LottoNumber lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public LottoNumber getLottoNumber() {
		return lottoNumber;
	}
}
