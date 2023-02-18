package domain;

import java.util.List;

public class DuplicateLottoNumbersRemover {
    private static final int INITIAL_COUNT = 0;

    private static int duplicateCount = INITIAL_COUNT;

    public static void removeDuplicates(List<LottoNumbers> manualLottoNumbersGroup, List<LottoNumbers> autoLottoNumbersGroup) {
        for (LottoNumbers autoLottoNumbers : autoLottoNumbersGroup) {
            changeDuplicateLottoNumbers(manualLottoNumbersGroup, autoLottoNumbers);
        }
        if (duplicateCount > INITIAL_COUNT) {
            duplicateCount = INITIAL_COUNT;
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
