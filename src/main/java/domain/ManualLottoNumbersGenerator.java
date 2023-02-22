package domain;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import view.InputView;

public class ManualLottoNumbersGenerator implements NumbersGenerator {

	@Override
	public LottoNumbers generateLottoNumbers(int size) {
		Set<LottoNumber> lottoNumbers = Arrays.stream(InputView.getManualLottoNumbers().split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.map(LottoNumber::new)
			.collect(Collectors.toCollection(TreeSet::new));
		return new LottoNumbers(lottoNumbers);
	}
}
