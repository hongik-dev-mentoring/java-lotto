package domain;

import java.util.List;

public class DuplicateLottoNumbersRemover {
    public static void removeDuplicates(List<LottoNumbers> manualLottoNumbersGroup, List<LottoNumbers> autoLottoNumbersGroup) {
        int duplicateCount = 0;
        for (LottoNumbers autoLottoNumbers : autoLottoNumbersGroup) {
            if (manualLottoNumbersGroup.contains(autoLottoNumbers)) {
                duplicateCount++;
                autoLottoNumbers.changeNumbers();
            }
        }
        if (duplicateCount != 0) {
            removeDuplicates(manualLottoNumbersGroup, autoLottoNumbersGroup);
        }
    }
}
