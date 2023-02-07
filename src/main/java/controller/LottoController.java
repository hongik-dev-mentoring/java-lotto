package controller;

import domain.LottoDto;
import domain.LottoGenerator;
import view.Input;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void startLotto() {
        Integer price = Input.readPrice();

        Integer purchaseNum = price/1000;

        System.out.println(purchaseNum);

        List<LottoDto> lottoDtoList = new ArrayList<>();

        for (int i = 0; i < purchaseNum; i++) {
            List<Integer> list = LottoGenerator.generate();
            lottoDtoList.add(new LottoDto(list));
        }
        lottoDtoList.forEach(ResultView::printLottoNumbers);
    }

}
