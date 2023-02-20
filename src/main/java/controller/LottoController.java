package controller;

import domain.*;
import dto.LottoTicketDto;
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
        LottoTicket lottoTicket = createLottoTicket(manualPurchaseNumber, autoPurchaseNumber);
        ResultView.printPurchaseInfo(manualPurchaseNumber, autoPurchaseNumber);
        ResultView.printLottoNumbersGroup(new LottoTicketDto(lottoTicket));
        createLottoStatistics(inputPrice, lottoTicket);
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

    private LottoTicket createLottoTicket(int manualPurchaseNumber, int autoPurchaseNumber) {
        LottoTicket manualLottoTicket = getManualLottoTicket(manualPurchaseNumber);
        LottoTicket autoLottoTicket = LottoNumbersAutoGenerator.generateAutoLottoTicket(autoPurchaseNumber);
        DuplicateLottoNumbersRemover.removeDuplicates(manualLottoTicket, autoLottoTicket);
        return autoLottoTicket.combine(manualLottoTicket);
    }

    private LottoTicket getManualLottoTicket(int manualPurchaseNumber) {
        try {
            List<String> manualLottoNumbers = InputView.readManualLottoNumbers(manualPurchaseNumber);
            return ManualLottoNumbersParser.parse(manualLottoNumbers);
        } catch (Exception e) {
            ResultView.printExceptionMessage(e);
            return getManualLottoTicket(manualPurchaseNumber);
        }
    }

    private void createLottoStatistics(int inputPrice, LottoTicket lottoTicket) {
        LottoNumbers lastLottoNumbers = getLastLottoNumbers();
        LottoNumber bonusNumber = getBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        LottoStatisticsCalculator lottoStatisticsCalculator = new LottoStatisticsCalculator(lottoTicket, lottoWinningNumbers);
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
