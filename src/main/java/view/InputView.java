package view;

import java.util.Scanner;

public class InputView {

	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
	private static final Scanner console = new Scanner(System.in);

	public static String getPurchaseAmount() {
		System.out.println(INPUT_MONEY_MESSAGE);
		return console.nextLine();
	}

	public static String getWinningNumbers() {
		System.out.println(INPUT_WINNING_LOTTO_NUMBER_MESSAGE);
		return console.nextLine();
	}

	public static String getBonusBallNumber() {
		System.out.println(INPUT_BONUS_BALL_NUMBER_MESSAGE);
		return console.nextLine();
	}
}
