package controller;

import domain.*;
import dto.LottoNumbersGroupDto;
import dto.LottoResultMapDto;
import parser.BonusNumberParser;
import parser.InputPriceParser;
import parser.LastLottoNumbersParser;
import view.InputView;
import view.ResultView;

import java.util.EnumMap;
import java.util.List;

public class LottoController {

    public void startLotto() {
        int inputPrice = getInputPrice();
        int purchaseNumber = PurchaseNumberCalculator.calculate(inputPrice);
        ResultView.printPurchaseInfo(purchaseNumber);
        List<LottoNumbers> lottoNumbersGroup = LottoNumbersGenerator.generateLottoNumbersGroup(purchaseNumber);
        ResultView.printLottoNumbersGroup(new LottoNumbersGroupDto(lottoNumbersGroup));
        createLottoStatistics(inputPrice, lottoNumbersGroup);
    }

    private int getInputPrice() {
        try {
            String input = InputView.readPrice();
            return InputPriceParser.parse(input);
        } catch (Exception e) {
            ResultView.printExceptionMessage(e);
            return getInputPrice();
        }
    }

    private void createLottoStatistics(int inputPrice, List<LottoNumbers> lottoNumbersGroup) {
        LottoNumbers lastLottoNumbers = getLastLottoNumbers();
        LottoNumber bonusNumber = getBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        LottoStatisticsCalculator lottoStatisticsCalculator = new LottoStatisticsCalculator(lottoNumbersGroup, lottoWinningNumbers);
        EnumMap<LottoPrize, Integer> resultMap = lottoStatisticsCalculator.calculate();
        ResultView.printLottoResult(new LottoResultMapDto(resultMap)); //
        double benefit = LottoBenefitCalculator.calculate(inputPrice, resultMap);
        ResultView.printBenefit(benefit);
    }

    private LottoNumbers getLastLottoNumbers() {
        try {
            String input = InputView.readLastLottoNumbers();
            return LastLottoNumbersParser.parse(input);
        } catch (Exception e) {
            ResultView.printExceptionMessage(e);
            return getLastLottoNumbers();
        }
    }

    private LottoNumber getBonusNumber() {
        try {
            String input = InputView.readBonusNumber();
            return BonusNumberParser.parse(input);
        } catch (Exception e) {
            ResultView.printExceptionMessage(e);
            return getBonusNumber();
        }
    }
}
