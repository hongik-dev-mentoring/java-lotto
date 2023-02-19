package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoPurchaseCountTest {

    @Test
    void 현재_남은_갯수를_넘는_갯수의_로또를_구매할_수_없다() {
        LottoPurchaseCount lottoPurchaseCount = new LottoPurchaseCount(10);
        assertThatThrownBy(() -> lottoPurchaseCount.decreaseCount(100))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 수동 로또 구매 갯수는 구매 가능 갯수를 넘어갈 수 없습니다.");
    }
}
