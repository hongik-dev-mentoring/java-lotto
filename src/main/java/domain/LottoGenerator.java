package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final Integer CANDIDATE_MIN_NUMBER = 1;
    public static final Integer CANDIDATE_MAX_NUMBER = 45;
    public static final Integer NUMBER_OF_LOTTO_NUMS = 6;

    private List<Integer> lottoCandidateNumbers = new ArrayList<>();

    public List<Integer> generate() {

        for (int i = CANDIDATE_MIN_NUMBER; i <= CANDIDATE_MAX_NUMBER; i++) {
            lottoCandidateNumbers.add(i);
        }

        Collections.shuffle(lottoCandidateNumbers);

        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_LOTTO_NUMS; i++) {
            System.out.println(lottoCandidateNumbers.get(i));
            lottoNumbers.add(lottoCandidateNumbers.get(i));
        }
        return lottoNumbers;
    }
}
