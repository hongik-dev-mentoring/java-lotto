package view;

import java.util.Scanner;

public class InputView {

	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
	private static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String REQUEST_POSITIVE_MANUAL_NUMBER_MESSAGE = "[ERROR] 0 이상의 숫자를 입력해 주세요.";
	private static final String REQUEST_NUMBER_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
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

	public static int getManualLottoCount() {
		try {
			System.out.println(MANUAL_LOTTO_COUNT_MESSAGE);
			int manualLottoCount = Integer.parseInt(console.nextLine());
			validatePositive(manualLottoCount);
			return manualLottoCount;
		} catch (NumberFormatException e) {
			OutputView.printErrorMessage(REQUEST_NUMBER_MESSAGE);
			return getManualLottoCount();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getManualLottoCount();
		}
	}

	private static void validatePositive(int number) {
		if (number < 0) {
			throw new IllegalArgumentException(REQUEST_POSITIVE_MANUAL_NUMBER_MESSAGE);
		}
	}

	public static String getManualLottoNumbers() {
		try {
			Integer.parseInt(console.nextLine());
			return console.nextLine();
		} catch (NumberFormatException e) {
			OutputView.printErrorMessage(REQUEST_NUMBER_MESSAGE);
		}
		return getManualLottoNumbers();
	}

	public static void requestManualLotto() {
		System.out.println(MANUAL_LOTTO_NUMBER_MESSAGE);
	}
}
