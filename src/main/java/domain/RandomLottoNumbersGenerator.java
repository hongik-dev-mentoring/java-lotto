package domain;

import java.util.Set;
import java.util.TreeSet;

public class RandomLottoNumbersGenerator implements NumbersGenerator {

	@Override
	public LottoNumbers generateLottoNumbers(int size) {
		Set<LottoNumber> lottoNumbers = new TreeSet<>();
		while (lottoNumbers.size() != size) {
			lottoNumbers.add(RandomLottoNumberGenerator.generate());
		}
		return new LottoNumbers(lottoNumbers);
	}
}
