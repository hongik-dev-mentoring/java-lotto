package domain;

public class InputPrice {

    private static final int MIN_INPUT_PRICE =1000;
    private final int price;

    public InputPrice(String input) {
        int price = checkInputFormat(input);
        checkMinimumPrice(price);
        this.price = price;
    }

    private int checkInputFormat(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자여야 합니다.");
        }
    }

    private void checkMinimumPrice(int price) {
        if (price < MIN_INPUT_PRICE) {
            throw new IllegalArgumentException("구입금액은 1000원 이상이어야 합니다.");
        }
    }

    public int getPrice() {
        return price;
    }
}
