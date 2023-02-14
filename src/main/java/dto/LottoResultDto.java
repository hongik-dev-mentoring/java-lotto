package dto;

import java.util.EnumMap;

public class LottoResultDto {

	private final EnumMap<RankDto, Integer> lottoResult;

	public LottoResultDto(EnumMap<RankDto, Integer> lottoResult) {
		this.lottoResult = lottoResult;
	}

	public EnumMap<RankDto, Integer> getLottoResult() {
		return lottoResult;
	}
}
