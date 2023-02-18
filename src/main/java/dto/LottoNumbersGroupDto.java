package dto;

import domain.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGroupDto {
    private final List<LottoNumbersDto> lottoNumbersGroup;

    public LottoNumbersGroupDto(List<LottoNumbers> lottoNumbersGroup) {
        this.lottoNumbersGroup = lottoNumbersGroup.stream()
                .map(LottoNumbersDto::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumbersDto> getLottoNumbersGroup() {
        return lottoNumbersGroup;
    }
}
