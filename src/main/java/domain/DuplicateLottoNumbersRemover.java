package domain;

public class DuplicateLottoNumbersRemover {
    private static final int INITIAL_COUNT = 0;

    private static int duplicateCount = INITIAL_COUNT;

    public static void removeDuplicates(LottoTicket manualLottoTicket, LottoTicket autoLottoTicket) {
        for (LottoNumbers autoLottoNumbers : autoLottoTicket.getLottoNumbersGroup()) {
            changeDuplicateLottoNumbers(manualLottoTicket, autoLottoNumbers);
        }
        if (duplicateCount > INITIAL_COUNT) {
            duplicateCount = INITIAL_COUNT;
            removeDuplicates(manualLottoTicket, autoLottoTicket);
        }
    }

    private static void changeDuplicateLottoNumbers(LottoTicket manualLottoTicket, LottoNumbers autoLottoNumbers) {
        if (manualLottoTicket.contains(autoLottoNumbers)) {
            duplicateCount++;
            autoLottoNumbers.changeNumbers();
        }
    }
}
