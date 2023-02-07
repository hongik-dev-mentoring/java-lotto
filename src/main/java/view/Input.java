package view;

import java.util.Scanner;

public class Input {
    public static Integer readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return Integer.parseInt(input);
    }
}
