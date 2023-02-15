package view;

import domain.LottoDto;
import domain.LottoPrize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLottoNumbers(List<LottoDto> lottoGroup) {
        lottoGroup.forEach((ResultView::createLottoViewText));
    }

    private static void createLottoViewText(LottoDto lotto) {
        System.out.print("[");
        String result = lotto.getLottoNumbers()
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

    public static void printBenefit(double benefit) {
        StringBuilder stringBuilder = new StringBuilder()
                .append("총 수익률은 ")
                .append(benefit)
                .append("입니다.");
        System.out.println(stringBuilder);
    }

    public static void printPurchaseInfo(int purchaseNum) {
        System.out.println(purchaseNum + "개를 구매했습니다.");
    }
}
