package util.generator;

import java.util.Set;
import java.util.TreeSet;

import domain.LottoNumber;
import domain.LottoNumbers;

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
