package view;

import domain.LottoDto;
import domain.LottoEnum;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLottoNumbers(LottoDto lottoDto) {
        System.out.print("[");
        String result = lottoDto.getLottoNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.print(result);
        System.out.println("]");
    }

    public static void printStatistics(Map<String, Integer> lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Map.Entry<String, Integer> lottoEntry : lottoStatistics.entrySet()) {
            LottoEnum lottoEnum = LottoEnum.valueOf(lottoEntry.getKey());
            System.out.println(lottoEnum.getPrizeText() + "- " + lottoEntry.getValue() + "개");
        }
    }

    public static void printBenefit(Integer inputPrice, Map<String, Integer> statisticsMap) {
        int rewardSum = 0;
        for (Map.Entry<String, Integer> lottoEntry : statisticsMap.entrySet()) {
            LottoEnum lottoEnum = LottoEnum.valueOf(lottoEntry.getKey());
            rewardSum += lottoEnum.getReward() * lottoEntry.getValue();
        }
        System.out.printf("%.2f", (double) rewardSum / inputPrice);
    }

    public static void printPurchaseInfo(int purchaseNum) {
        System.out.println(purchaseNum + "개를 구매했습니다.");
    }
}
