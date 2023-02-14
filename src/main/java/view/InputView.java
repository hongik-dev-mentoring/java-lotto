package view;

import parser.BonusNumberParser;
import parser.InputPriceParser;
import parser.LastLottoNumbersParser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = scanner.nextLine();
            return InputPriceParser.parse(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readPrice();
        }
    }

    public static List<Integer> readLastLottoNumbers() {
        try {
            System.out.println("지난 주 당첨번호를 입력하세요.");
            String input = scanner.nextLine();
            return LastLottoNumbersParser.parse(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readLastLottoNumbers();
        }
    }

    public static int readBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해주세요.");
            String input = scanner.nextLine();
            return BonusNumberParser.parse(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBonusNumber();
        }
    }

}
