package view;

import java.util.Scanner;

public class InputView {

	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final Scanner console = new Scanner(System.in);

	public static String getPurchaseAmount() {
		System.out.println(INPUT_MONEY_MESSAGE);
		return console.nextLine();
	}
}
