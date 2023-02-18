package controller;

import domain.*;
import dto.LottoNumbersGroupDto;
import dto.LottoResultMapDto;
import parser.*;
import view.InputView;
import view.ResultView;

import java.util.EnumMap;
import java.util.List;

public class LottoController {

    public void startLotto() {
        int inputPrice = getInputPrice();
        int totalPurchaseNumber = PurchaseNumberCalculator.calculateTotalPurchaseNumber(inputPrice);
        int manualPurchaseNumber = getManualLottoPurchaseNumber(totalPurchaseNumber);
        int autoPurchaseNumber = PurchaseNumberCalculator.calculateAutoPurchaseNumber(totalPurchaseNumber, manualPurchaseNumber);
        List<LottoNumbers> lottoNumbersGroup = createLottoTickets(manualPurchaseNumber, autoPurchaseNumber);
        ResultView.printPurchaseInfo(manualPurchaseNumber, autoPurchaseNumber);
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

    private int getManualLottoPurchaseNumber(int totalPurchaseNumber) {
        try {
            String input = InputView.readManualLottoPurchaseNumber();
            return ManualLottoPurchaseNumberParser.parse(input, totalPurchaseNumber);
        } catch (Exception e) {
            ResultView.printExceptionMessage(e);
            return getManualLottoPurchaseNumber(totalPurchaseNumber);
        }
    }

    private List<LottoNumbers> createLottoTickets(int manualPurchaseNumber, int autoPurchaseNumber) {
        List<LottoNumbers> manualLottoNumberGroup = getManualLottoNumbersGroup(manualPurchaseNumber);
        List<LottoNumbers> autoLottoNumbersGroup = LottoNumbersAutoGenerator.generateAutoLottoNumbersGroup(autoPurchaseNumber);
        DuplicateLottoNumbersRemover.removeDuplicates(manualLottoNumberGroup, autoLottoNumbersGroup);
        return LottoNumbersGroupCombiner.combine(manualLottoNumberGroup, autoLottoNumbersGroup);
    }

    private List<LottoNumbers> getManualLottoNumbersGroup(int manualPurchaseNumber) {
        try {
            List<String> manualLottoNumbers = InputView.readManualLottoNumbers(manualPurchaseNumber);
            return ManualLottoNumbersParser.parse(manualLottoNumbers);
        } catch (Exception e) {
            ResultView.printExceptionMessage(e);
            return getManualLottoNumbersGroup(manualPurchaseNumber);
        }
    }

    private void createLottoStatistics(int inputPrice, List<LottoNumbers> lottoNumbersGroup) {
        LottoNumbers lastLottoNumbers = getLastLottoNumbers();
        LottoNumber bonusNumber = getBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        LottoStatisticsCalculator lottoStatisticsCalculator = new LottoStatisticsCalculator(lottoNumbersGroup, lottoWinningNumbers);
        EnumMap<LottoPrize, Integer> resultMap = lottoStatisticsCalculator.calculate();
        ResultView.printLottoResult(new LottoResultMapDto(resultMap));
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
