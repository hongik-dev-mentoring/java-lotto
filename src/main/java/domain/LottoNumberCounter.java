package domain;

public class LottoNumberCounter {
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoNumberCounter(LottoWinningNumbers lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public LottoPrize decideLottoPrize(LottoNumbers lottoNumbers) {
        int count = countLottoNumbers(lottoNumbers);
        boolean hasBonus = countBonusNumber(lottoNumbers);
        return LottoPrize.selectLottoPrize(count, hasBonus);
    }

    private int countLottoNumbers(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.getLottoNumbers()
                .stream()
                .filter(this::checkContainsLottoNumber)
                .count();
    }

    private boolean checkContainsLottoNumber(LottoNumber lottoNumber) {
        return lottoWinningNumbers.containsLottoNumber(lottoNumber);
    }

    private boolean countBonusNumber(LottoNumbers lottoNumbers) {
        return lottoNumbers.getLottoNumbers()
                .stream()
                .filter(this::checkContainsBonusNumber)
                .count() == 1;
    }

    private boolean checkContainsBonusNumber(LottoNumber number) {
        return lottoWinningNumbers.containsBonusNumber(number);
    }
}
