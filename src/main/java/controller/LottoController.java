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
        int purchaseNum = PurchaseNumCalculator.calculateLotto(inputPrice);
        int manualLottoNum = Input.readManualLottoNum();

        List<LottoNumbers> lottoNumbersGroup = generateLottoNumbersGroup(manualLottoNum, purchaseNum);

        ResultView.printInputGuide();
        LottoWinningNumbers lottoWinningNumbers = readWinningNumbers();

        LottoChecker lottoChecker = new LottoChecker(lottoNumbersGroup, lottoWinningNumbers);
        Map<LottoPrize, Integer> statisticsMap = lottoChecker.calculateLottoStatistics();
        ResultView.printStatistics(statisticsMap);
        ResultView.printBenefit(lottoChecker.getBenefit(statisticsMap, inputPrice));
    }

    private List<LottoNumbers> generateLottoNumbersGroup(int manualLottoNum, int purchaseNum) {
        List<LottoNumbers> lottoNumbersGroup = new ArrayList<>();
        int autoLottoNum = purchaseNum - manualLottoNum;

        ResultView.printManualLottoInputGuide();
        for (int i = 0; i < manualLottoNum; i++) {
            lottoNumbersGroup.add(new LottoNumbers(Input.readLottoNumbers()));
        }

        ResultView.printPurchaseLottoDetails(manualLottoNum, autoLottoNum);
        LottoGenerator.generateAutoLottoNumber(lottoNumbersGroup, autoLottoNum);

        ResultView.printLottoNumbers(lottoNumbersGroup);
        return lottoNumbersGroup;
    }

    private LottoWinningNumbers readWinningNumbers() {
        List<Integer> winningLottoNumbers = Input.readLottoNumbers();
        int bonusNumber = Input.readBonusNumber();
        return new LottoWinningNumbers(winningLottoNumbers, bonusNumber);
    }
}
