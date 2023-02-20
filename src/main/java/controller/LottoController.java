package controller;

import java.util.EnumMap;
import java.util.List;

import domain.BonusBall;
import domain.BonusBallConvertor;
import domain.Lotto;
import domain.LottoNumbers;
import domain.LottoTicket;
import domain.ManualLottoNumbersGenerator;
import domain.PurchaseAmountConvertor;
import domain.RandomLottoNumbersGenerator;
import domain.Rank;
import domain.RankDiscriminator;
import domain.TotalPrizeCalculator;
import domain.WinningNumberConvertor;
import domain.WinningNumbers;
import dto.LottoResultDto;
import dto.LottoTicketDto;
import dto.RankDto;
import util.calculator.ProfitRateCalculator;
import util.calculator.PurchaseCountCalculator;
import view.InputView;
import view.OutputView;

public class LottoController {

	private static final int LOTTO_TICKET_PER_PRICE = 1000;
	private int purchaseAmount;

	private static final LottoController instance = new LottoController();

	private LottoController() {
	}

	public static LottoController getInstance() {
		return instance;
	}

	public void run() {
		purchaseLotto();
	}

	private void purchaseLotto() {
		getPurchaseAmount();
		int totalLottoCount = PurchaseCountCalculator.calculateCount(purchaseAmount, LOTTO_TICKET_PER_PRICE);
		int manualLottoCount = getManualLottoCount();

		int autoLottoCount = totalLottoCount - manualLottoCount;

		InputView.requestManualLotto();
		Lotto manualLotto = getManualLotto(manualLottoCount);
		Lotto autoLotto = getAutoLotto(autoLottoCount);

		LottoTicket autoLottoTicket = autoLotto.getLottoTicketNumbers();
		LottoTicket manualLottoTicket = manualLotto.getLottoTicketNumbers();

		List<LottoNumbers> manualLottoTickets = manualLottoTicket.getLottoTicket();
		manualLottoTickets.addAll(autoLottoTicket.getLottoTicket());
		LottoTicket totalLottoTicket = new LottoTicket(manualLottoTickets);

		OutputView.printLottoTicket(new LottoTicketDto(totalLottoTicket), manualLottoCount, autoLottoCount);
		drawLotto(totalLottoTicket);
	}

	private void getPurchaseAmount() {
		try {
			purchaseAmount = PurchaseAmountConvertor.convertPurchaseAmount(InputView.getPurchaseAmount());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getPurchaseAmount();
		}
	}

	private int getManualLottoCount() {
		try {
			return InputView.getManualLottoCount();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return getManualLottoCount();
	}

	private Lotto getManualLotto(int manualLottoCount) {
		try {
			Lotto manualLotto = new Lotto(new ManualLottoNumbersGenerator());
			manualLotto.getManualLottos(manualLottoCount);
			return manualLotto;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return getManualLotto(manualLottoCount);
	}

	private static Lotto getAutoLotto(int autoLottoCount) {
		try {
			Lotto autoLotto = new Lotto(new RandomLottoNumbersGenerator());
			autoLotto.getAutoLottos(autoLottoCount);
			return autoLotto;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return getAutoLotto(autoLottoCount);
	}

	private void drawLotto(LottoTicket totalLottoTicket) {
		WinningNumbers winningNumbers = getWinningNumbers();
		BonusBall bonusBall = getBonusBall(winningNumbers);
		announceLottoResult(winningNumbers, bonusBall, totalLottoTicket);
	}

	private WinningNumbers getWinningNumbers() {
		try {
			return WinningNumberConvertor.convertWinningNumber(InputView.getWinningNumbers());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return getWinningNumbers();
	}

	private BonusBall getBonusBall(WinningNumbers winningNumbers) {
		try {
			return new BonusBall(BonusBallConvertor.convertBonusNumber(InputView.getBonusBallNumber()), winningNumbers);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return getBonusBall(winningNumbers);
	}

	private void announceLottoResult(WinningNumbers winningNumbers, BonusBall bonusBall, LottoTicket totalLottoTicket) {
		RankDiscriminator rankDiscriminator = new RankDiscriminator(winningNumbers, bonusBall);
		EnumMap<Rank, Integer> lottoResult = rankDiscriminator.checkLottoResult(totalLottoTicket);

		EnumMap<RankDto, Integer> lottoResultsDto = new EnumMap<>(RankDto.class);
		lottoResult.forEach((key, value) -> lottoResultsDto.put(RankDto.valueOf(key.name()), value));

		LottoResultDto lottoResultDto = new LottoResultDto(lottoResultsDto);
		OutputView.printLottoResult(lottoResultDto, ProfitRateCalculator.calculateProfitRate(
			TotalPrizeCalculator.calculateTotalPrize(lottoResult), purchaseAmount));
	}
}
