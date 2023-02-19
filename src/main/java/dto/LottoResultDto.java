package dto;

import java.util.EnumMap;

import domain.Ranking;

public class LottoResultDto {

	private final EnumMap<Ranking, Integer> lottoResult;

	public LottoResultDto(EnumMap<Ranking, Integer> lottoResult) {
		this.lottoResult = lottoResult;
	}

	public EnumMap<Ranking, Integer> getLottoResult() {
		return lottoResult;
	}
}
