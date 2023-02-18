package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String readLastLottoNumbers() {
        System.out.println("지난 주 당첨번호를 입력하세요.");
        return scanner.nextLine();
    }

    public static String readBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return scanner.nextLine();
    }
}
