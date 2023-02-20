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

    private static final List<LottoNumber> lottoCandidateNumbers = generateCandidateNumbers();

    private static List<LottoNumber> generateCandidateNumbers() {
        return IntStream.rangeClosed(CANDIDATE_MIN_NUMBER, CANDIDATE_MAX_NUMBER)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static List<LottoNumbers> generateAutoLottoNumbersGroup(int purchaseNumber) {
        List<LottoNumbers> lottoNumbersGroup = new ArrayList<>();
        for (int i = 0; i < purchaseNumber; i++) {
            List<LottoNumber> lottoNumbers = generateAutoLottoNumbers();
            lottoNumbersGroup.add(new LottoNumbers(lottoNumbers));
        }
        return lottoNumbersGroup;
    }

    public static List<LottoNumber> generateAutoLottoNumbers() {
        Collections.shuffle(lottoCandidateNumbers);
        return selectLottoNumbers();
    }

    private static List<LottoNumber> selectLottoNumbers() {
        return lottoCandidateNumbers.stream()
                .limit(NUMBER_OF_LOTTO_NUMBERS)
                .collect(Collectors.toList());
    }
}
