package view;

import domain.LottoNumbers;
import domain.LottoPrize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLottoNumbers(List<LottoNumbers> lottoNumberGroup) {
        for (LottoNumbers lottoNumber : lottoNumberGroup) {
            printLottoNumber(lottoNumber);
        }
    }

    private static void printLottoNumber(LottoNumbers lottoNumber) {
        System.out.print("[");
        String result = lottoNumber.getLottoNumbers()
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
        str += " (" + lottoPrize.getReward() + ")- " + value + "개";
        System.out.println(str);
    }

    public static void printBenefit(double benefit) {
        System.out.printf("%.2f", benefit);
    }

    public static void printInputGuide() {
        System.out.println("지난 주 당첨번호를 입력하세요.");
    }

    public static void printManualLottoInputGuide() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printPurchaseLottoDetails(int manualLottoNum, int autoLottoNum) {
        System.out.println("수동으로 " + manualLottoNum + "장, 자동으로 " + autoLottoNum + "개를 구매했습니다.");
    }
}
