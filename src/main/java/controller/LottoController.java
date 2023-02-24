package controller;

import domain.LottoPurchaseCount;
import domain.numbers.LottoNumber;
import domain.numbers.LottoNumberGenerator;
import java.util.ArrayList;
import java.util.EnumMap;

import domain.Lotto;
import domain.LottoTicket;
import domain.Ranking;
import domain.numbers.WinningNumber;
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

	private Lotto lotto;
	private WinningNumber winningNumber;
	private LottoTicket manualLottoTicket;
	private int purchaseAmount;
	private LottoPurchaseCount lottoPurchaseCount;
	private int manualLottoPurchaseCount;

	public void purchaseLotto() {
		purchaseAmount = getPurchaseAmount();
		lottoPurchaseCount = new LottoPurchaseCount(PurchaseCountCalculator.calculateCount(purchaseAmount, LOTTO_TICKET_PER_PRICE));
		manualLottoPurchaseCount = getPurchaseManualLottoCount();

		List<LottoNumber> manualLottoNumbers = new ArrayList<>();
		for (int i = 0; i < manualLottoPurchaseCount; i++) {
			manualLottoNumbers.add(getManualLottoNumber());
		}
		manualLottoTicket = new LottoTicket(manualLottoNumbers);
	}

	private int getPurchaseAmount() {
		try {
			return PurchaseAmountConvertor.convertPurchaseAmount(InputView.getPurchaseAmount());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getPurchaseAmount();
		}
	}

	private int getPurchaseManualLottoCount() {
		try {
			int purchaseCount = PurchaseCountConvertor.convertPurchaseCount(InputView.getManualLottoPurchaseCount());
			lottoPurchaseCount = lottoPurchaseCount.decreaseCount(purchaseCount);
			return purchaseCount;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getPurchaseManualLottoCount();
		}
	}

	private LottoNumber getManualLottoNumber() {
		try {
			return LottoNumberConvertor.convertLottoNumbers(InputView.getWinningNumbers());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getManualLottoNumber();
		}
	}

	public void generateAutoLottoNumber() {
		OutputView.printLottoPurchaseCount(lottoPurchaseCount.getLottoPurchaseCount(), manualLottoPurchaseCount);

		lotto = Lotto.generateLottoWithManualLottoTicket(
			new LottoNumberGenerator(), lottoPurchaseCount.getLottoPurchaseCount(), manualLottoTicket);

		OutputView.printLottoTicket(new LottoTicketDto(lotto.getLottoTicket()));
		OutputView.printBlankLine();
	}

	public void drawLotto() {
		LottoNumber lottoNumber = getLottoNumbers();
		winningNumber = getWinningNumbers(lottoNumber);
		OutputView.printBlankLine();
	}

	private LottoNumber getLottoNumbers() {
		try {
			return LottoNumberConvertor.convertLottoNumbers(InputView.getWinningNumbers());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getLottoNumbers();
		}
	}

	private WinningNumber getWinningNumbers(LottoNumber winningNumbers) {
		try {
			int bonusBallNumber = LottoNumberConvertor.convertBonusNumber(InputView.getBonusBallNumber());
			return new WinningNumber(winningNumbers, bonusBallNumber);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getWinningNumbers(winningNumbers);
		}
	}

	public void announceLottoResult() {
		EnumMap<Ranking, Integer> lottoResult = lotto.checkLottoResult(winningNumber);
		LottoResultDto lottoResultDto = new LottoResultDto(lottoResult);
		OutputView.printLottoResult(lottoResultDto);

		OutputView.printProfitRate(ProfitRateCalculator.calculateProfitRate(
			TotalPrizeCalculator.calculateTotalPrize(lottoResult), purchaseAmount));
	}
}
