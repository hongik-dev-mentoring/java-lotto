package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbersGroupCombiner {
    public static List<LottoNumbers> combine(List<LottoNumbers> manualLottoNumberGroup, List<LottoNumbers> autoLottoNumbersGroup) {
        return Stream.concat(manualLottoNumberGroup.stream(), autoLottoNumbersGroup.stream())
                .collect(Collectors.toList());
    }
}
