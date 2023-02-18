package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        checkDuplicatedNumber(lottoNumbers);
        checkLottoNumbersSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkDuplicatedNumber(List<LottoNumber> lastLottoNumbers) {
        HashSet<LottoNumber> lottoNumberSet = new HashSet<>(lastLottoNumbers);
        if (lastLottoNumbers.size() != lottoNumberSet.size()) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    private void checkLottoNumbersSize(List<LottoNumber> lastLottoNumbers) {
        if (lastLottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public void changeNumbers() {
        this.lottoNumbers = LottoNumbersAutoGenerator.generateAutoLottoNumbers();
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
