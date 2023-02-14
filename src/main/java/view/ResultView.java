package view;

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

    public static void printLottoResult(Map<LottoPrize, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoPrize lottoPrize : LottoPrize.getSortedLottoPrizes()) {
            System.out.println(createStatisticsText(resultMap, lottoPrize));
        }
    }

    private static String createStatisticsText(Map<LottoPrize, Integer> resultMap, LottoPrize lottoPrize) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoPrize.getCount())
                .append("개 일치")
                .append(getBonusNumberText(lottoPrize))
                .append("(")
                .append(lottoPrize.getReward())
                .append("원)- ")
                .append(resultMap.get(lottoPrize))
                .append("개");
        return stringBuilder.toString();
    }

    private static String getBonusNumberText(LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.PRIZE_2ND) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }

    public static void printBenefit(int inputPrice, Map<LottoPrize, Integer> resultMap) {
        int rewardSum = 0;
        for (Map.Entry<LottoPrize, Integer> lottoEntry : resultMap.entrySet()) {
            LottoPrize lottoPrize = lottoEntry.getKey();
            rewardSum += lottoPrize.getReward() * lottoEntry.getValue();
        }
        System.out.printf("%.2f", (double) rewardSum / inputPrice);
    }

    public static void printPurchaseInfo(int purchaseNum) {
        System.out.println(purchaseNum + "개를 구매했습니다.");
    }
}
