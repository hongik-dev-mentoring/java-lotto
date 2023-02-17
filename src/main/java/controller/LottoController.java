package controller;

import java.util.EnumMap;

import domain.BonusBall;
import domain.Lotto;
import domain.LottoTicket;
import domain.PurchaseAmountConvertor;
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
import util.generator.LottoNumbersGenerator;
import view.InputView;
import view.OutputView;

public class LottoController {

	private static final int LOTTO_TICKET_PER_PRICE = 1000;

	private Integer purchaseAmount;
	private Lotto lotto;
	private WinningNumbers winningNumbers;
	private BonusBall bonusBall;

	public void purchaseLotto() {
		getPurchaseAmount();
		int calculateCount = PurchaseCountCalculator.calculateCount(purchaseAmount, LOTTO_TICKET_PER_PRICE);

		lotto = Lotto.generateLottoWithLottoNumbers(new LottoNumbersGenerator(), calculateCount);
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
			bonusBall = new BonusBall(WinningNumberConvertor.convertBonusNumber(InputView.getBonusBallNumber()), winningNumbers);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			getBonusBall();
		}
	}

	public void announceLottoResult() {
		RankDiscriminator rankDiscriminator = new RankDiscriminator(winningNumbers, bonusBall);
		EnumMap<Rank, Integer> lottoResult = rankDiscriminator.checkLottoResult(lotto.getLottoTicketNumbers());

		EnumMap<RankDto, Integer> lottoResultsDto = new EnumMap<>(RankDto.class);
		lottoResult.forEach((key, value) -> lottoResultsDto.put(RankDto.valueOf(key.name()), value));

		LottoResultDto lottoResultDto = new LottoResultDto(lottoResultsDto);
		OutputView.printLottoResult(lottoResultDto, ProfitRateCalculator.calculateProfitRate(
			TotalPrizeCalculator.calculateTotalPrize(lottoResult), purchaseAmount));
	}
}
