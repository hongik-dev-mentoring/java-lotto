package domain;

import view.Input;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final Integer CANDIDATE_MIN_NUMBER = 1;
    public static final Integer CANDIDATE_MAX_NUMBER = 45;
    public static final Integer NUMBER_OF_LOTTO_NUMS = 6;

    public static LottoNumbers generate() {
        List<Integer> lottoCandidateNumbers = generateCandidateNumbers();
        Collections.shuffle(lottoCandidateNumbers);
        List<Integer> lottoNumbers = generateLottoNumbers(lottoCandidateNumbers);

        return new LottoNumbers(lottoNumbers);
    }

    public static void generateAutoLottoNumber(List<LottoNumbers> lottoNumbersGroup, int autoLottoNum) {
        for (int i = 0; i < autoLottoNum; i++) {
            LottoNumbers lottoNumbers = LottoGenerator.generate();
            lottoNumbersGroup.add(lottoNumbers);
        }
    }

    private static List<Integer> generateCandidateNumbers() {
        return IntStream.rangeClosed(CANDIDATE_MIN_NUMBER, CANDIDATE_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> generateLottoNumbers(List<Integer> lottoCandidateNumbers) {
        return lottoCandidateNumbers.stream()
                .limit(NUMBER_OF_LOTTO_NUMS)
                .collect(Collectors.toList());
    }
}
