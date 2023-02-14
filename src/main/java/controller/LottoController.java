package controller;

import domain.*;
import parser.BonusNumberParser;
import parser.InputPriceParser;
import parser.LastLottoNumbersParser;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    public void startLotto() {
        int inputPrice = getInputPrice();
        int purchaseNum = calculatePurchaseNum(inputPrice);
        List<LottoDto> lottoDtoGroup = generateLottoDtoList(purchaseNum);
        List<Integer> lastLottoNumbers = getLastLottoNumbers();
        int bonusNumber = getBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
        createLottoStatistics(inputPrice, lottoDtoGroup, lottoWinningNumbers);
    }

    private static int getInputPrice() {
        try {
            String input = InputView.readPrice();
            return InputPriceParser.parse(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInputPrice();
        }
    }

    private int calculatePurchaseNum(int inputPrice) {
        int purchaseNum = inputPrice / LOTTO_PRICE;
        ResultView.printPurchaseInfo(purchaseNum);
        return purchaseNum;
    }

    private List<LottoDto> generateLottoDtoList(int purchaseNum) {
        List<LottoDto> lottoDtoGroup = new ArrayList<>();
        for (int i = 0; i < purchaseNum; i++) {
            LottoDto lottoDto = LottoGenerator.generate();
            lottoDtoGroup.add(lottoDto);
            ResultView.printLottoNumbers(lottoDto);
        }
        return lottoDtoGroup;
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

    private void createLottoStatistics(int inputPrice, List<LottoDto> lottoDtoGroup, LottoWinningNumbers lottoWinningNumbers) {
        LottoChecker lottoChecker = new LottoChecker(lottoDtoGroup, lottoWinningNumbers);
        Map<LottoPrize, Integer> statisticsMap = lottoChecker.calculateLottoStatistics();
        ResultView.printLottoResult(statisticsMap);
        ResultView.printBenefit(inputPrice, statisticsMap);
    }
}
