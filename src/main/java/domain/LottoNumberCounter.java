package domain;

import java.util.stream.Collectors;

public class LottoNumberCounter {
    private final LottoWinningNumbers lottoWinningNumbers;

    public LottoNumberCounter(LottoWinningNumbers lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public LottoPrize decideLottoPrize(LottoDto dto) {
        int count = countLottoNumbers(dto);
        boolean hasBonus = countBonusNumber(dto);
        return LottoPrize.selectLottoPrize(count, hasBonus);
    }

    private int countLottoNumbers(LottoDto lottoDto) {
        return (int) lottoDto.getLottoNumbers()
                .stream()
                .filter(this::checkContainsLottoNumber)
                .count();
    }

    private boolean checkContainsLottoNumber(int number) {
        return lottoWinningNumbers.containsLottoNumber(number);
    }

    private boolean countBonusNumber(LottoDto lottoDto) {
        return lottoDto.getLottoNumbers()
                .stream()
                .filter(this::checkContainsBonusNumber)
                .count() == 1;
    }

    private boolean checkContainsBonusNumber(int number) {
        return lottoWinningNumbers.containsBonusNumber(number);
    }
}
