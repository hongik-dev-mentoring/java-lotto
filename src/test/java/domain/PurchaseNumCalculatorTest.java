package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseNumCalculatorTest {

    @Test
    @DisplayName("로또 갯수 정상 반환 테스트")
    public void purchaseNumTest() {
        //given
        int inputPrice = 14000;
        //when
        int purchaseNum = PurchaseNumCalculator.calculateLotto(inputPrice);
        //then
        assertThat(purchaseNum).isEqualTo(14);
    }
}
