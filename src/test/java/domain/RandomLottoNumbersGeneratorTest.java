package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DisplayNameGenerator.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class RandomLottoNumbersGeneratorTest {

	@Test
	void 랜덤_로또번호를_여섯_개_생성한다() {
		RandomLottoNumbersGenerator randomLottoNumbersGenerator = new RandomLottoNumbersGenerator();

		LottoNumbers lottoNumbers = randomLottoNumbersGenerator.generateLottoNumbers(6);

		assertThat(lottoNumbers.getNumbers().size()).isEqualTo(6);
	}

}