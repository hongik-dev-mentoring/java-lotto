package domain;

import java.util.HashSet;
import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

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
            throw new IllegalArgumentException("당첨번호 6개를 다시 입력해주세요.");
        }
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.stream()
                .filter((lottoNumber) -> lottoNumber.equals(number))
                .count() == 1;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
