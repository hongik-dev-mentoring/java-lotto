package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    public final Scanner sc = new Scanner(System.in);

    public Integer readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }

    public List<Integer> readLastLottoNumbers() {
        System.out.println("지난 주 당첨번호를 입력하세요.");
        String input = sc.nextLine();
        return Arrays.stream(input.split(","))
                .map((number) -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }

    public Integer readBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }
}
