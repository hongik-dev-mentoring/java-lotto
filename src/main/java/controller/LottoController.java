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
	private LottoTicket totalLottoTicket;
	private WinningNumbers winningNumbers;
	private BonusBall bonusBall;
	private Lotto manualLotto;
	private Lotto autoLotto;

	public void purchaseLotto() {
		getPurchaseAmount();
		int totalLottoCount = PurchaseCountCalculator.calculateCount(purchaseAmount, LOTTO_TICKET_PER_PRICE);
		int manualLottoCount = getManualLottoCount();

		int autoLottoCount = totalLottoCount - manualLottoCount;

		manualLotto = new Lotto(new ManualLottoNumbersGenerator());
		manualLotto = getManualLottos(manualLottoCount);
		autoLotto = new Lotto(new RandomLottoNumbersGenerator());
		autoLotto = getAuttoLottos(autoLottoCount);

		LottoTicket autoLottoTicket = autoLotto.getLottoTicketNumbers();
		LottoTicket manualLottoTicket = manualLotto.getLottoTicketNumbers();

		List<LottoNumbers> manualLottoTickets = manualLottoTicket.getLottoTicket();
		manualLottoTickets.addAll(autoLottoTicket.getLottoTicket());
		totalLottoTicket = new LottoTicket(manualLottoTickets);

		OutputView.printLottoTicket(new LottoTicketDto(totalLottoTicket), manualLottoCount, autoLottoCount);
	}

	private int getManualLottoCount() {
		try {
			return InputView.getManualLottoCount();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
		}
		return getManualLottoCount();
	}

	private Lotto getManualLottos(int manualLottoCount) {
		InputView.requestManualLotto();
		for (int i = 0; i < manualLottoCount; ++i) {
			generateManualLotto();
		}
		return manualLotto;
	}

	private void generateManualLotto() {
		try {
			manualLotto.generateLottoTicket();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			generateManualLotto();
		}
	}

	private Lotto getAuttoLottos(int autoLottoCount) {
		for (int i = 0; i < autoLottoCount; ++i) {
			autoLotto.generateLottoTicket();
		}
		return autoLotto;
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
			bonusBall = new BonusBall(BonusBallConvertor.convertBonusNumber(InputView.getBonusBallNumber()), winningNumbers);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getBonusBall();
		}
	}

	public void announceLottoResult() {
		RankDiscriminator rankDiscriminator = new RankDiscriminator(winningNumbers, bonusBall);
		EnumMap<Rank, Integer> lottoResult = rankDiscriminator.checkLottoResult(totalLottoTicket);

		EnumMap<RankDto, Integer> lottoResultsDto = new EnumMap<>(RankDto.class);
		lottoResult.forEach((key, value) -> lottoResultsDto.put(RankDto.valueOf(key.name()), value));

		LottoResultDto lottoResultDto = new LottoResultDto(lottoResultsDto);
		OutputView.printLottoResult(lottoResultDto, ProfitRateCalculator.calculateProfitRate(
			TotalPrizeCalculator.calculateTotalPrize(lottoResult), purchaseAmount));
	}
}
