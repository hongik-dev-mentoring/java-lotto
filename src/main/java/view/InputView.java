package view;

import domain.BonusNumber;
import domain.InputPrice;
import domain.LastLottoNumbers;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static InputPrice readPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = scanner.nextLine();
            return new InputPrice(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readPrice();
        }
    }

    public static LastLottoNumbers readLastLottoNumbers() {
        try {
            System.out.println("지난 주 당첨번호를 입력하세요.");
            String input = scanner.nextLine();
            return new LastLottoNumbers(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readLastLottoNumbers();
        }
    }

    public static BonusNumber readBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해주세요.");
            String input = scanner.nextLine();
            return new BonusNumber(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBonusNumber();
        }
    }

}
