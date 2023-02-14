package controller;

import java.util.EnumMap;

import domain.BonusBall;
import domain.Lotto;
import domain.LottoNumberGenerator;
import domain.LottoTicket;
import domain.Rank;
import domain.RankDiscriminator;
import domain.WinningNumbers;
import dto.LottoResultDto;
import dto.LottoTicketDto;
import util.calculator.ProfitRateCalculator;
import util.calculator.PurchaseCountCalculator;
import domain.TotalPrizeCalculator;
import domain.WinningNumberConvertor;
import domain.PurchaseAmountConvertor;
import view.InputView;
import view.OutputView;

public class LottoController {

	private static final int LOTTO_TICKET_PER_PRICE = 1000;
	private final int FROM = 1;
	private final int TO = 46;
	private final int LOTTO_NUMBER_LIMIT = 6;

	private Integer purchaseAmount;
	private Lotto lotto;
	private WinningNumbers winningNumbers;
	private BonusBall bonusBall;

	public void purchaseLotto() {
		getPurchaseAmount();
		int calculateCount = PurchaseCountCalculator.calculateCount(purchaseAmount, LOTTO_TICKET_PER_PRICE);

		lotto = Lotto.generateLottoWithLottoNumbers(
			new LottoNumberGenerator(FROM, TO, LOTTO_NUMBER_LIMIT), calculateCount);
		LottoTicket lottoTicket = lotto.getLottoTicketNumbers();
		OutputView.printLottoTicket(new LottoTicketDto(lottoTicket), calculateCount);
	}

	private void getPurchaseAmount() {
		try {
			purchaseAmount = PurchaseAmountConvertor.convertPurchaseAmount(InputView.getPurchaseAmount());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getPurchaseAmount();
		}
	}

	public void drawLotto() {
		getWinningNumbers();
		getBonusBall();
	}

	private void getWinningNumbers() {
		try {
			winningNumbers =  WinningNumberConvertor.convertWinningNumber(InputView.getWinningNumbers());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getWinningNumbers();
		}
	}

	private void getBonusBall() {
		try {
			bonusBall = BonusBall.createBonusBallInRange(
				FROM, TO, WinningNumberConvertor.convertBonusNumber(InputView.getBonusBallNumber()), winningNumbers);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getBonusBall();
		}
	}

	public void announceLottoResult() {
		RankDiscriminator rankDiscriminator = new RankDiscriminator(winningNumbers, bonusBall);
		EnumMap<Rank, Integer> lottoResult = rankDiscriminator.checkLottoResult(lotto.getLottoTicketNumbers());
		LottoResultDto lottoResultDto = new LottoResultDto(lottoResult);
		OutputView.printLottoResult(lottoResultDto, ProfitRateCalculator.calculateProfitRate(
			TotalPrizeCalculator.calculateTotalPrize(lottoResult), purchaseAmount));
	}
}
