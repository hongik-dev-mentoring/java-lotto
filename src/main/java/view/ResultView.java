package view;

import domain.InputPrice;
import domain.LottoDto;
import domain.LottoPrize;

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
            LottoPrize lottoPrize = LottoPrize.valueOf(lottoEntry.getKey());
            System.out.println(lottoPrize.getPrizeText() + "- " + lottoEntry.getValue() + "개");
        }
    }

    public static void printBenefit(InputPrice inputPrice, Map<String, Integer> statisticsMap) {
        int rewardSum = 0;
        for (Map.Entry<String, Integer> lottoEntry : statisticsMap.entrySet()) {
            LottoPrize lottoPrize = LottoPrize.valueOf(lottoEntry.getKey());
            rewardSum += lottoPrize.getReward() * lottoEntry.getValue();
        }
        // TODO: 반올림하지 않고 내림으로 변경
        System.out.printf("%.2f", (double) rewardSum / inputPrice.getPrice());
    }

    public static void printPurchaseInfo(int purchaseNum) {
        System.out.println(purchaseNum + "개를 구매했습니다.");
    }
}
