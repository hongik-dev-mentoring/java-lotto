package controller;

import domain.*;
import view.Input;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    public void startLotto() {
        InputPrice inputPrice = inputPrice();
        int purchaseNum = calculatePurchaseNum(inputPrice);
        List<LottoDto> lottoDtoGroup = generateLottoDtoList(purchaseNum);
        LottoWinningNumbers lottoWinningNumbers = readWinningNumbers();
        createLottoStatistics(inputPrice, lottoDtoGroup, lottoWinningNumbers);
    }

    private InputPrice inputPrice() {
        Input input = new Input();
        return input.readPrice();
    }

    private int calculatePurchaseNum(InputPrice inputPrice) {
        int purchaseNum = inputPrice.getPrice() / LOTTO_PRICE;
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

    private LottoWinningNumbers readWinningNumbers() {
        Input input = new Input();
        LastLottoNumbers lastLottoNumbers = input.readLastLottoNumbers();
        BonusNumber bonusNumber = input.readBonusNumber();
        return new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
    }

    private void createLottoStatistics(InputPrice inputPrice, List<LottoDto> lottoDtoGroup, LottoWinningNumbers lottoWinningNumbers) {
        LottoChecker lottoChecker = new LottoChecker(lottoDtoGroup, lottoWinningNumbers);
        Map<String, Integer> statisticsMap = lottoChecker.calculateLottoStatistics();
        ResultView.printStatistics(statisticsMap);
        ResultView.printBenefit(inputPrice, statisticsMap);
    }
}
