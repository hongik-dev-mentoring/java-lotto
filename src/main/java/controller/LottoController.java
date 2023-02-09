package controller;

import domain.LottoChecker;
import domain.LottoDto;
import domain.LottoGenerator;
import domain.LottoWinningNumbers;
import view.Input;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    public void startLotto() {
        Input input = new Input();
        int inputPrice = input.readPrice();
        int purchaseNum = inputPrice / LOTTO_PRICE;
        ResultView.printPurchaseInfo(purchaseNum);

        List<LottoDto> lottoDtoList = generateLottoDtoList(purchaseNum);
        LottoWinningNumbers lottoWinningNumbers = readWinningNumbers();
        createLottoStatistics(inputPrice, lottoDtoList, lottoWinningNumbers);
    }

    private List<LottoDto> generateLottoDtoList(int purchaseNum) {
        List<LottoDto> lottoDtoList = new ArrayList<>();
        for (int i = 0; i < purchaseNum; i++) {
            LottoDto lottoDto = LottoGenerator.generate();
            lottoDtoList.add(lottoDto);
            ResultView.printLottoNumbers(lottoDto);
        }
        return lottoDtoList;
    }

    private LottoWinningNumbers readWinningNumbers() {
        Input input = new Input();
        List<Integer> lastLottoNumbers = input.readLastLottoNumbers();
        int bonusNumber = input.readBonusNumber();
        return new LottoWinningNumbers(lastLottoNumbers, bonusNumber);
    }

    private void createLottoStatistics(Integer inputPrice, List<LottoDto> lottoDtoList, LottoWinningNumbers lottoWinningNumbers) {
        LottoChecker lottoChecker = new LottoChecker(lottoDtoList, lottoWinningNumbers);
        Map<String, Integer> statisticsMap = lottoChecker.calculateLottoStatistics();
        ResultView.printStatistics(statisticsMap);
        ResultView.printBenefit(inputPrice, statisticsMap);
    }
}
