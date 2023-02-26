package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeTest {

    @Test
    @DisplayName("로또 1등 당첨시 PRIZE_1ST 반환 테스트")
    public void testFirstPrize() {
        //when
        LottoPrize lottoPrize = LottoPrize.decideLottoPrize(6, false);
        //then
        assertThat(lottoPrize).isEqualTo(LottoPrize.PRIZE_1ST);
    }

    @Test
    @DisplayName("로또 2등 당첨시 PRIZE_2ND 반환 테스트")
    public void testSecondPrize() {
        //when
        LottoPrize lottoPrize = LottoPrize.decideLottoPrize(5, true);
        //then
        assertThat(lottoPrize).isEqualTo(LottoPrize.PRIZE_2ND);
    }

    @Test
    @DisplayName("로또 3등 당첨시 PRIZE_3rd 반환 테스트")
    public void testThirdPrize() {
        //when
        LottoPrize lottoPrize = LottoPrize.decideLottoPrize(5, false);
        //then
        assertThat(lottoPrize).isEqualTo(LottoPrize.PRIZE_3RD);
    }

    @Test
    @DisplayName("로또 4등 당첨시 PRIZE_4TH 반환 테스트")
    public void testFourthPrize() {
        //when
        LottoPrize lottoPrize = LottoPrize.decideLottoPrize(4, false);
        //then
        assertThat(lottoPrize).isEqualTo(LottoPrize.PRIZE_4TH);
    }

    @Test
    @DisplayName("로또 5등 당첨시 PRIZE_5TH 반환 테스트")
    public void testFifthPrize() {
        //when
        LottoPrize lottoPrize = LottoPrize.decideLottoPrize(3, false);
        //then
        assertThat(lottoPrize).isEqualTo(LottoPrize.PRIZE_5TH);
    }
}
