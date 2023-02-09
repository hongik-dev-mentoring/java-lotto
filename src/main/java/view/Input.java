package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String COMMA_DELIMITER =",";

    public final Scanner sc = new Scanner(System.in);
    private int price;
    private List<Integer> lastLottoNumbers;
    private int bonusNumber;

    public Integer readPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = sc.nextLine();
            price = Integer.parseInt(input);
            InputException.handleMinimum(price);
        } catch (Exception e) {
            System.out.println("1000원 이상의 숫자로 된 금액을 입력해주세요");
            return readPrice();
        }
        return price;
    }

    public List<Integer> readLastLottoNumbers() {
        try {
            System.out.println("지난 주 당첨번호를 입력하세요.");
            String input = sc.nextLine();
            lastLottoNumbers = new ArrayList<>();
            validateLastLottoNumbers(lastLottoNumbers, input.split(COMMA_DELIMITER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readLastLottoNumbers();
        }
        return lastLottoNumbers;
    }

    public int readBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해주세요.");
            String input = sc.nextLine();
            bonusNumber = Integer.parseInt(input);
            InputException.handleLottoNumberRange(bonusNumber);
        } catch (Exception e) {
            System.out.println("1에서 45사이의 숫자를 입력하세요.");
            return readBonusNumber();
        }
        return bonusNumber;
    }
}
