package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RankDiscriminatorTest {

	@BeforeEach
	void initialize() {

	}

	@Test
	void 숫자3개가_일치하면_5등에_당첨된다() {

	}

	@Test
	void 숫자4개가_일치하면_4등에_당첨된다() {

	}

	@Test
	void 숫자5개가_일치하고_보너스볼이_불일치하면_3등에_당첨된다() {

	}

	@Test
	void 숫자5개가_일치하고_보너스볼이_일치하면_2등에_당첨된다() {

	}

	@Test
	void 숫자6개가_일치하면_1등에_당첨된다() {

	}
}