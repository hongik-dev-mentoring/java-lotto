package controller;

import domain.*;
import view.Input;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void startLotto() {
        int inputPrice = Input.readPrice();
        int purchaseNum = inputPrice / LottoChecker.getLottoPrice();
        ResultView.printPurchaseInfo(purchaseNum);

        List<LottoNumbers> lottoNumbersGroup = new ArrayList<>();
        for (int i = 0; i < purchaseNum; i++) {
            LottoNumbers lottoNumbers = LottoGenerator.generate();
            lottoNumbersGroup.add(lottoNumbers);
            ResultView.printLottoNumbers(lottoNumbers);
        }

        ResultView.printInputGuide();
        LottoWinningNumbers lottoWinningNumbers = readWinningNumbers();
        LottoChecker lottoChecker = new LottoChecker(lottoNumbersGroup, lottoWinningNumbers);

        Map<String, Integer> statisticsMap = lottoChecker.calculateLottoStatistics();
        ResultView.printStatistics(statisticsMap);
        ResultView.printBenefit(lottoChecker.getBenefit(statisticsMap));
    }

    private LottoWinningNumbers readWinningNumbers() {
        List<Integer> lastLottoNumbers = Input.readLastLottoNumbers();
        int bonusNumber = Input.readBonusNumber();
        return new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
    }
}
