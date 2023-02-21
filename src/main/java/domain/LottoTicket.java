package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private final List<LottoNumbers> lottoNumbersGroup;

    public LottoTicket(List<LottoNumbers> lottoNumbersGroup) {
        this.lottoNumbersGroup = new ArrayList<>(lottoNumbersGroup);
    }

    public LottoTicket combine(LottoTicket lottoTicket) {
        List<LottoNumbers> combinedLottoNumbersGroup = Stream.concat(lottoTicket.getLottoNumbersGroup().stream(), lottoNumbersGroup.stream())
                .collect(Collectors.toList());
        return new LottoTicket(combinedLottoNumbersGroup);
    }

    public List<LottoNumbers> getLottoNumbersGroup() {
        return lottoNumbersGroup;
    }

    public boolean contains(LottoNumbers lottoNumbers) {
        return lottoNumbersGroup.contains(lottoNumbers);
    }
}
