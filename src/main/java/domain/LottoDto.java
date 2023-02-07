package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoDto {
    private List<Integer> lottoNumbers;

    public LottoDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public List<Integer> getLottoDto() {
        return lottoNumbers;
    }
}
