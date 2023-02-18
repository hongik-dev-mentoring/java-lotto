package domain;

import java.util.List;

public class DuplicateLottoNumbersRemover {
    private static int duplicateCount = 0;

    public static void removeDuplicates(List<LottoNumbers> manualLottoNumbersGroup, List<LottoNumbers> autoLottoNumbersGroup) {
        for (LottoNumbers autoLottoNumbers : autoLottoNumbersGroup) {
            changeDuplicateLottoNumbers(manualLottoNumbersGroup, autoLottoNumbers);
        }
        if (duplicateCount != 0) {
            duplicateCount = 0;
            removeDuplicates(manualLottoNumbersGroup, autoLottoNumbersGroup);
        }
    }

    private static void changeDuplicateLottoNumbers(List<LottoNumbers> manualLottoNumbersGroup, LottoNumbers autoLottoNumbers) {
        if (manualLottoNumbersGroup.contains(autoLottoNumbers)) {
            duplicateCount++;
            autoLottoNumbers.changeNumbers();
        }
    }
}
