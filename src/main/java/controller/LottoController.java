package controller;

import domain.*;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    public void startLotto() {
        int inputPrice = InputView.readPrice();
        int purchaseNum = calculatePurchaseNum(inputPrice);
        List<LottoDto> lottoDtoGroup = generateLottoDtoList(purchaseNum);
        LottoWinningNumbers lottoWinningNumbers = readWinningNumbers();
        createLottoStatistics(inputPrice, lottoDtoGroup, lottoWinningNumbers);
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

    private LottoWinningNumbers readWinningNumbers() {
        List<Integer> lastLottoNumbers = InputView.readLastLottoNumbers();
        int bonusNumber = InputView.readBonusNumber();
        return new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
    }

    private void createLottoStatistics(int inputPrice, List<LottoDto> lottoDtoGroup, LottoWinningNumbers lottoWinningNumbers) {
        LottoChecker lottoChecker = new LottoChecker(lottoDtoGroup, lottoWinningNumbers);
        Map<String, Integer> statisticsMap = lottoChecker.calculateLottoStatistics();
        ResultView.printStatistics(statisticsMap);
        ResultView.printBenefit(inputPrice, statisticsMap);
    }
}
