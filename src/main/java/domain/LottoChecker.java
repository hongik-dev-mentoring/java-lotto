package domain;

import java.util.*;

public class LottoChecker {

    private final List<LottoDto> lottoDtoList;
    private final List<Integer> lastLottoNumbers;
    private final Integer bonusNumber;

    public LottoChecker(List<LottoDto> lottoDtoList, List<Integer> lastLottoNumbers, Integer bonusNumber) {
        this.lottoDtoList = new ArrayList<>(lottoDtoList);
        this.lastLottoNumbers = new ArrayList<>(lastLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Map<String, Integer> calculateLottoStatistics() {

        Map<String, Integer> calculateResult = new TreeMap<>(Comparator.reverseOrder());

        calculateResult.put("PRIZE_1ST", 0);
        calculateResult.put("PRIZE_2ND", 0);
        calculateResult.put("PRIZE_3RD", 0);
        calculateResult.put("PRIZE_4TH", 0);
        calculateResult.put("PRIZE_5TH", 0);

        for (LottoDto dto : lottoDtoList) {
            int count = 0;
            boolean hasBonusNumber = false;
            for (int number : dto.getLottoNumbers()) {
                if (lastLottoNumbers.contains(number)) {
                    count++;
                }
                if (number == bonusNumber) {
                    count++;
                    hasBonusNumber = true;
                }
            }

            if (count == 3) {
                calculateResult.put("PRIZE_5TH", calculateResult.get("PRIZE_5TH") + 1);
            }
            if (count == 4) {
                calculateResult.put("PRIZE_4TH", calculateResult.get("PRIZE_4TH") + 1);
            }
            if (count == 5 && hasBonusNumber) {
                calculateResult.put("PRIZE_2ND", calculateResult.get("PRIZE_2ND") + 1);
                continue;
            }
            if (count == 5) {
                calculateResult.put("PRIZE_3RD", calculateResult.get("PRIZE_3RD") + 1);
            }
            if (count == 6) {
                calculateResult.put("PRIZE_1ST", calculateResult.get("PRIZE_1ST") + 1);
            }

        }
        return calculateResult;
    }

}
