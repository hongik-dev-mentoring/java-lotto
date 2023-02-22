import controller.LottoController;

public class LottoApplication {

	public static void main(String[] args) {
		LottoController lottoController = LottoController.getInstance();
		lottoController.run();
	}
}
