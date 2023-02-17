package dto;

import domain.LottoPrize;

import java.util.EnumMap;

public class LottoResultMapDto {
    private final EnumMap<LottoPrize, Integer> resultMap;

    public LottoResultMapDto(EnumMap<LottoPrize, Integer> resultMap) {
        this.resultMap = new EnumMap<>(resultMap);
    }

    public EnumMap<LottoPrize, Integer> getResultMap() {
        return resultMap;
    }
}
