package view;

import domain.LottoNumbers;
import domain.LottoEnum;

import java.util.List;
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

    public static void printStatistics(Map<String, Integer> lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Map.Entry<String, Integer> lottoEntry : lottoStatistics.entrySet()) {
            LottoEnum lottoEnum = LottoEnum.valueOf(lottoEntry.getKey());
            System.out.println(lottoEnum.getPrizeText() + "- " + lottoEntry.getValue() + "개");
        }
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
