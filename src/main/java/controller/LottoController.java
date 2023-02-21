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
        int purchaseNum = inputPrice / LottoNumbers.getLottoPrice();
        int manualLottoNum = Input.readManualLottoNum();

        List<LottoNumbers> lottoNumbersGroup = lottoNumbersGroupGenerator(manualLottoNum, purchaseNum);

        ResultView.printInputGuide();
        LottoWinningNumbers lottoWinningNumbers = readWinningNumbers();

        LottoChecker lottoChecker = new LottoChecker(lottoNumbersGroup, lottoWinningNumbers);
        Map<LottoPrize, Integer> statisticsMap = lottoChecker.calculateLottoStatistics();
        ResultView.printStatistics(statisticsMap);
        ResultView.printBenefit(lottoChecker.getBenefit(statisticsMap, inputPrice));
    }

    private List<LottoNumbers> lottoNumbersGroupGenerator(int manualLottoNum, int purchaseNum) {
        List<LottoNumbers> lottoNumbersGroup = new ArrayList<>();
        int autoLottoNum = purchaseNum - manualLottoNum;

        ResultView.printManualLottoInputGuide();
        LottoGenerator.manualLottoNumberGenerator(manualLottoNum, lottoNumbersGroup);

        ResultView.printPurchaseLottoDetails(manualLottoNum, autoLottoNum);
        LottoGenerator.autoLottoNumberGenerator(lottoNumbersGroup, autoLottoNum);

        ResultView.printLottoNumbers(lottoNumbersGroup);
        return lottoNumbersGroup;
    }

    private LottoWinningNumbers readWinningNumbers() {
        List<Integer> winningLottoNumbers = Input.readLottoNumbers();
        int bonusNumber = Input.readBonusNumber();
        return new LottoWinningNumbers(winningLottoNumbers, bonusNumber);
    }
}
