package view;

import domain.LottoNumbers;
import domain.LottoPrize;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLottoNumbers(LottoNumbers lottoNumbers) {
        System.out.print("[");
        String result = lottoNumbers.getLottoNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.print(result);
        System.out.println("]");
    }

    public static void printStatistics(Map<LottoPrize, Integer> lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Map.Entry<LottoPrize, Integer> lottoEntry : lottoStatistics.entrySet()) {
            printResultLine(lottoEntry);
        }
    }

    private static void printResultLine(Map.Entry<LottoPrize, Integer> lottoEntry) {
        LottoPrize lottoPrize = lottoEntry.getKey();
        Integer value = lottoEntry.getValue();
        String str = lottoPrize.getMatchingNum() + "개 일치";
        if (lottoPrize.isHasBonusNum()) {
            str += ", 보너스 볼 일치";
        }
        str+= " (" + lottoPrize.getReward() + ")- " + value + "개";
        System.out.println(str);
    }

    public static void printBenefit(double benefit) {
        System.out.printf("%.2f", benefit);
    }

    public static void printPurchaseInfo(int purchaseNum) {
        System.out.println(purchaseNum + "개를 구매했습니다.");
    }

    public static void printInputGuide() {
        System.out.println("지난 주 당첨번호를 입력하세요.");
    }
}
