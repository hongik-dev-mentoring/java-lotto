package view;

import domain.LottoPrize;
import dto.LottoNumbersDto;
import dto.LottoNumbersGroupDto;
import dto.LottoResultMapDto;

import java.util.EnumMap;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLottoNumbersGroup(LottoNumbersGroupDto dto) {
        dto.getLottoNumbersGroup()
                .forEach(ResultView::createLottoViewText);
    }

    private static void createLottoViewText(LottoNumbersDto dto) {
        System.out.print("[");
        String result = dto.getLottoNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.print(result);
        System.out.println("]");
    }

    public static void printLottoResult(LottoResultMapDto dto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoPrize lottoPrize : LottoPrize.getSortedLottoPrizes()) {
            System.out.println(createStatisticsText(dto.getResultMap(), lottoPrize));
        }
    }

    private static String createStatisticsText(EnumMap<LottoPrize, Integer> resultMap, LottoPrize lottoPrize) {
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

    public static void printPurchaseInfo(int manualPurchaseNumber, int autoPurchaseNumber) {
        StringBuilder stringBuilder = new StringBuilder()
                .append("수동으로 ")
                .append(manualPurchaseNumber)
                .append("장, ")
                .append("자동으로 ")
                .append(autoPurchaseNumber)
                .append("개를 구매했습니다.");
        System.out.println(stringBuilder);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
