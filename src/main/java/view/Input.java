package view;

import util.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String COMMA_DELIMITER = ",";

    private static final Scanner sc = new Scanner(System.in);

    public static Integer readPrice() {
        int price;
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

    public static Integer readManualLottoNum() {
        int ManualLottoNum;
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            String input = sc.nextLine();
            ManualLottoNum = Integer.parseInt(input);
            InputException.handlePositive(ManualLottoNum);
        } catch (Exception e) {
            System.out.println("0이상의 숫자를 입력해주세요.");
            return readManualLottoNum();
        }
        return ManualLottoNum;
    }

    public static List<Integer> readLottoNumbers() {
        List<Integer> lastLottoNumbers;
        try {
            String input = sc.nextLine();
            lastLottoNumbers = new ArrayList<>();
            validateLastLottoNumbers(lastLottoNumbers, input.split(COMMA_DELIMITER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readLottoNumbers();
        }
        return lastLottoNumbers;
    }

    public static int readBonusNumber() {
        int bonusNumber;
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

    private static void validateLastLottoNumbers(List<Integer> lastLottoNumbers, String[] input) {
        for (String component : input) {
            int lottoNumber = InputException.handleInputFormat(component.trim());
            InputException.handleLottoNumberRange(lottoNumber);
            InputException.handleDuplicate(lastLottoNumbers, lottoNumber);
            lastLottoNumbers.add(lottoNumber);
        }
        InputException.handleLottoNumbersSize(lastLottoNumbers);
    }
}
