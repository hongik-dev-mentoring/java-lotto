package dto;

import java.util.EnumMap;

import domain.Rank;

public class LottoResultDto {

	private final EnumMap<Rank, Integer> lottoResult;

	public LottoResultDto(EnumMap<Rank, Integer> lottoResult) {
		this.lottoResult = lottoResult;
	}

	public EnumMap<Rank, Integer> getLottoResult() {
		return lottoResult;
	}
}
