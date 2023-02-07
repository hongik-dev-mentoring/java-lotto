package view;

import domain.LottoDto;

import java.util.stream.Collectors;

public class ResultView {
    public static void printLottoNumbers(LottoDto lottoDto) {
        System.out.print("[");
        String result = lottoDto.getLottoNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.print(result);
        System.out.println("]");
    }
}
