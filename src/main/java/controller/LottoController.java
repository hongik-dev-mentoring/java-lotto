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

    public void startLotto() {
        Input input = new Input();
        Integer inputPrice = input.readPrice();
        Integer purchaseNum = inputPrice/1000;
        System.out.println(purchaseNum + "개를 구매했습니다.");

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
