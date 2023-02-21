package parser;

public class InputPriceParser {
    private static final String INPUT_PRICE_FORMAT_EXCEPTION_MESSAGE = "구입금액은 숫자여야 합니다.";
    private static final String INPUT_PRICE_MINIMUM_EXCEPTION_MESSAGE = "구입금액은 1000원 이상이어야 합니다.";

    private static final int MIN_INPUT_PRICE = 1000;

    public static int parse(String input) {
        int inputPrice = checkInputFormat(input);
        checkMinimumPrice(inputPrice);
        return inputPrice;
    }

    private static int checkInputFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_PRICE_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static void checkMinimumPrice(int price) {
        if (price < MIN_INPUT_PRICE) {
            throw new IllegalArgumentException(INPUT_PRICE_MINIMUM_EXCEPTION_MESSAGE);
        }
    }
}
