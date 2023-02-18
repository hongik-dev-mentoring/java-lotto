package parser;

public class ManualLottoPurchaseNumberParser {
    private static final String MANUAL_LOTTO_NUMBER_FORMAT_EXCEPTION_MESSAGE = "구입할 수동 로또의 개수는 숫자여야 합니다.";
    private static final String MANUAL_LOTTO_NUMBER_LIMIT_EXCEPTIOIN_MESSAGE = "수동 로또 금액이 총 구입금액을 초과할 수 없습니다.";

    public static int parse(String input, int totalPurchaseNumber) {
        int manualPurchaseNumber = checkInputFormat(input);
        checkPurchaseNumberLimit(manualPurchaseNumber, totalPurchaseNumber);
        return manualPurchaseNumber;
    }

    private static int checkInputFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MANUAL_LOTTO_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static void checkPurchaseNumberLimit(int purchaseNumber, int totalPurchaseNumber) {
        if (purchaseNumber > totalPurchaseNumber) {
            throw new IllegalArgumentException(MANUAL_LOTTO_NUMBER_LIMIT_EXCEPTIOIN_MESSAGE);
        }
    }
}
