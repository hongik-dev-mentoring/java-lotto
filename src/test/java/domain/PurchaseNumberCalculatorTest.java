package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseNumberCalculatorTest {
    @Test
    @DisplayName("로또 총 구매횟수 계산 테스트")
    public void calculateToTalPurchaseNumberTest() {
        // given
        int inputPrice = 14000;
        // when
        int purchaseNumber = PurchaseNumberCalculator.calculateTotalPurchaseNumber(inputPrice);
        // then
        assertThat(purchaseNumber).isEqualTo(14);
    }

    @Test
    @DisplayName("구매횟수 경계값 계산 테스트")
    public void roundDownPurchaseNumberTest() {
        // given
        int inputPrice = 13999;
        // when
        int purchaseNumber = PurchaseNumberCalculator.calculateTotalPurchaseNumber(inputPrice);
        // then
        assertThat(purchaseNumber).isEqualTo(13);
    }

    @Test
    @DisplayName("자동 로또 구매횟수 계산 테스트")
    public void calculateAutoPurchaseNumberTest() {
        // given
        int totalPurchaseNumber = 14;
        int manualPurchaseNumber = 3;
        // when
        int autoPurchaseNumber = PurchaseNumberCalculator.calculateAutoPurchaseNumber(totalPurchaseNumber, manualPurchaseNumber);
        // then
        assertThat(autoPurchaseNumber).isEqualTo(11);
    }
}