package controller;

import domain.*;
import parser.BonusNumberParser;
import parser.InputPriceParser;
import parser.LastLottoNumbersParser;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void startLotto() {
        int inputPrice = getInputPrice();
        int purchaseNum = PurchaseNumberCalculator.calculate(inputPrice);
        ResultView.printPurchaseInfo(purchaseNum);
        List<LottoDto> lottoDtoGroup = LottoGenerator.generateLottos(purchaseNum);
        ResultView.printLottoNumbers(lottoDtoGroup);
        createLottoStatistics(inputPrice ,lottoDtoGroup);
    }

    private int getInputPrice() {
        try {
            String input = InputView.readPrice();
            return InputPriceParser.parse(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInputPrice();
        }
    }

    private void createLottoStatistics(int inputPrice, List<LottoDto> lottoDtoGroup) {
        List<Integer> lastLottoNumbers = getLastLottoNumbers();
        int bonusNumber = getBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        LottoStatisticsCalculator lottoStatisticsCalculator = new LottoStatisticsCalculator(lottoDtoGroup, lottoWinningNumbers);
        Map<LottoPrize, Integer> resultMap = lottoStatisticsCalculator.calculate();
        ResultView.printLottoResult(resultMap);
        double benefit = LottoBenefitCalculator.calculate(inputPrice, resultMap);
        ResultView.printBenefit(benefit);
    }

    private List<Integer> getLastLottoNumbers() {
        try {
            String input = InputView.readLastLottoNumbers();
            return LastLottoNumbersParser.parse(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getLastLottoNumbers();
        }
    }

    private int getBonusNumber() {
        try {
            String input = InputView.readBonusNumber();
            return BonusNumberParser.parse(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }
}
