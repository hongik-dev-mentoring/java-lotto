package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers;
    private static final int LOTTO_PRICE = 1000;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }
}
