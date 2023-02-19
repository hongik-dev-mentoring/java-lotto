package controller;

import domain.LottoNumberRange;
import domain.LottoPurchaseCount;
import domain.numbers.LottoNumbers;
import java.util.ArrayList;
import java.util.EnumMap;

import domain.BonusBall;
import domain.Lotto;
import domain.LottoNumberGenerator;
import domain.LottoTicket;
import domain.Ranking;
import domain.numbers.WinningNumbers;
import dto.LottoResultDto;
import dto.LottoTicketDto;
import java.util.List;
import util.calculator.ProfitRateCalculator;
import util.calculator.PurchaseCountCalculator;
import util.calculator.TotalPrizeCalculator;
import util.convertor.LottoNumberConvertor;
import util.convertor.PurchaseAmountConvertor;
import util.convertor.PurchaseCountConvertor;
import view.InputView;
import view.OutputView;

public class LottoController {

	private static final int LOTTO_TICKET_PER_PRICE = 1000;
	private static final int FROM = 1;
	private static final int TO = 46;
	private static final int LOTTO_SIZE = 6;

	private final LottoNumberRange lottoNumberRange;
	private Lotto lotto;
	private WinningNumbers winningNumbers;
	private LottoTicket manualLottoTicket;
	private BonusBall bonusBall;
	private LottoPurchaseCount lottoPurchaseCount;
	private int purchaseAmount;
	private int manualLottoPurchaseCount;

	public LottoController() {
		lottoNumberRange = new LottoNumberRange(FROM, TO);
	}

	public void purchaseLotto() {
		getPurchaseAmount();
		lottoPurchaseCount = new LottoPurchaseCount(PurchaseCountCalculator.calculateCount(purchaseAmount, LOTTO_TICKET_PER_PRICE));
		getPurchaseManualLottoCount();

		List<LottoNumbers> manualLottoNumbers = new ArrayList<>();
		for (int i = 0; i < manualLottoPurchaseCount; i++) {
			manualLottoNumbers.add(getManualLottoNumber());
		}
		manualLottoTicket = new LottoTicket(manualLottoNumbers);
	}

	private void getPurchaseAmount() {
		try {
			purchaseAmount = PurchaseAmountConvertor.convertPurchaseAmount(InputView.getPurchaseAmount());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getPurchaseAmount();
		}
	}

	private int getPurchaseManualLottoCount() {
		try {
			manualLottoPurchaseCount = PurchaseCountConvertor.convertPurchaseCount(InputView.getManualLottoPurchaseCount());
			lottoPurchaseCount = lottoPurchaseCount.decreaseCount(manualLottoPurchaseCount);
			return manualLottoPurchaseCount;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getPurchaseManualLottoCount();
		}
	}

	private LottoNumbers getManualLottoNumber() {
		try {
			return LottoNumberConvertor.convertWinningNumber(InputView.getWinningNumbers());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getManualLottoNumber();
		}
	}

	public void generateAutoLottoNumber() {
		OutputView.printLottoPurchaseCount(lottoPurchaseCount.getLottoPurchaseCount(), manualLottoPurchaseCount);

		lotto = Lotto.generateLottoWithManualLottoTicket(
			new LottoNumberGenerator(lottoNumberRange, LOTTO_SIZE), lottoPurchaseCount.getLottoPurchaseCount(), manualLottoTicket);
		LottoTicket lottoTicket = lotto.getLottoNumbers();
		OutputView.printLottoTicket(new LottoTicketDto(lottoTicket));
		OutputView.printBlankLine();
	}

	public void drawLotto() {
		getWinningNumbers();
		getBonusBall();
		OutputView.printBlankLine();
	}

	private void getWinningNumbers() {
		try {
			winningNumbers =  LottoNumberConvertor.convertWinningNumber(InputView.getWinningNumbers());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getWinningNumbers();
		}
	}

	private void getBonusBall() {
		try {
			bonusBall = BonusBall.createBonusBallInRange(
				lottoNumberRange, LottoNumberConvertor.convertBonusNumber(InputView.getBonusBallNumber()), winningNumbers);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getBonusBall();
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
