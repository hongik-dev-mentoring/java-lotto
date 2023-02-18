package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersAutoGenerator {
    private static final int CANDIDATE_MIN_NUMBER = 1;
    private static final int CANDIDATE_MAX_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public static List<LottoNumbers> generateLottoNumbersGroup(int purchaseNumber) {
        List<LottoNumbers> lottoNumbersGroup = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            LottoNumbers lottoNumbers = generateLottoNumbers();
            // 수동 로또와 중복체크
            lottoNumbersGroup.add(lottoNumbers);
        }
        return lottoNumbersGroup;
    }

    private static LottoNumbers generateLottoNumbers() {
        List<LottoNumber> lottoCandidateNumbers = generateCandidateNumbers();
        Collections.shuffle(lottoCandidateNumbers);
        List<LottoNumber> lottoNumbers = selectLottoNumbers(lottoCandidateNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static List<LottoNumber> generateCandidateNumbers() {
        return IntStream.rangeClosed(CANDIDATE_MIN_NUMBER, CANDIDATE_MAX_NUMBER)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> selectLottoNumbers(List<LottoNumber> lottoCandidateNumbers) {
        return lottoCandidateNumbers.stream()
                .limit(NUMBER_OF_LOTTO_NUMBERS)
                .collect(Collectors.toList());
    }
}
