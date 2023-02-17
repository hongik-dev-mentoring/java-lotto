package dto;

import domain.LottoNumber;
import domain.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersDto {
    private final List<Integer> lottoNumbers;

    public LottoNumbersDto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers.getLottoNumbers()
                .stream()
                .mapToInt(LottoNumber::getNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
