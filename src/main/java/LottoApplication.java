import controller.LottoController;

public class LottoApplication {

	public static void main(String[] args) {
		LottoController lottoController = new LottoController();
		lottoController.purchaseLotto();
		lottoController.generateAutoLottoNumber();
		lottoController.drawLotto();
		lottoController.announceLottoResult();
	}
}
