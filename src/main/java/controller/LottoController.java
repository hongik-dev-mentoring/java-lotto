package controller;

import java.util.EnumMap;

import domain.BonusBall;
import domain.Lotto;
import domain.LottoNumberGenerator;
import domain.LottoNumbers;
import domain.LottoTicket;
import domain.Ranking;
import dto.LottoResultDto;
import dto.LottoTicketDto;
import util.calculator.ProfitRateCalculator;
import util.calculator.PurchaseCountCalculator;
import util.calculator.TotalPrizeCalculator;
import util.convertor.LottoNumberConvertor;
import util.convertor.PurchaseAmountConvertor;
import view.InputView;
import view.OutputView;

public class LottoController {

	private static final int LOTTO_TICKET_PER_PRICE = 1000;
	private final int FROM = 1;
	private final int TO = 46;
	private final int LOTTO_NUMBER_LIMIT = 6;
	private Integer purchaseAmount;
	private Lotto lotto;
	private static LottoNumbers winningNumbers;
	private BonusBall bonusBall;


	public void purchaseLotto() {
		try {
			purchaseAmount = PurchaseAmountConvertor.convertPurchaseAmount(InputView.getPurchaseAmount());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			purchaseLotto();
		}
		int calculateCount = PurchaseCountCalculator.calculateCount(purchaseAmount, LOTTO_TICKET_PER_PRICE);

		OutputView.printLottoPurchaseCount(calculateCount);

		lotto = Lotto.generateLottoWithLottoNumbers(
			new LottoNumberGenerator(FROM, TO, LOTTO_NUMBER_LIMIT), calculateCount);
		LottoTicket lottoTicket = lotto.getLottoNumbers();
		OutputView.printLottoTicket(new LottoTicketDto(lottoTicket));
		OutputView.printBlankLine();
	}

	public void drawLotto() {
		getWinningNumbers();
		getBonusBall();
		OutputView.printBlankLine();
	}

	private void getBonusBall() {
		try {
			bonusBall = BonusBall.createBonusBallInRange(
				FROM, TO, LottoNumberConvertor.convertBonusNumber(InputView.getBonusBallNumber()));
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getBonusBall();
		}
	}

	private static void getWinningNumbers() {
		try {
			winningNumbers =  LottoNumberConvertor.convertWinningNumber(InputView.getWinningNumbers());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getWinningNumbers();
		}
	}

	public void announceLottoResult() {
		EnumMap<Ranking, Integer> lottoResult = lotto.checkLottoResult(winningNumbers, bonusBall);
		LottoResultDto lottoResultDto = new LottoResultDto(lottoResult);
		OutputView.printLottoResult(lottoResultDto);

		OutputView.printProfitRate(ProfitRateCalculator.calculateProfitRate(
			TotalPrizeCalculator.calculateTotalPrize(lottoResult), purchaseAmount));
	}
}
