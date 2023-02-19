package domain;

public class LottoNumberRange {

    private final int startNumber;
    private final int endNumber;

    public LottoNumberRange(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public boolean checkInRanged(int number) {
        return startNumber <= number && number < endNumber;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }
}
