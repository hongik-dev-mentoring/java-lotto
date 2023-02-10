package view;

import domain.BonusNumber;
import domain.InputPrice;
import domain.LastLottoNumbers;

import java.util.Scanner;

public class Input {
    public final Scanner sc = new Scanner(System.in);

    public InputPrice readPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = sc.nextLine();
            return new InputPrice(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readPrice();
        }
    }

    public LastLottoNumbers readLastLottoNumbers() {
        try {
            System.out.println("지난 주 당첨번호를 입력하세요.");
            String input = sc.nextLine();
            return new LastLottoNumbers(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readLastLottoNumbers();
        }
    }

    public BonusNumber readBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해주세요.");
            String input = sc.nextLine();
            return new BonusNumber(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBonusNumber();
        }
    }

}
