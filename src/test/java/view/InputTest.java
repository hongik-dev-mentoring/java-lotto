package view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

class InputTest {

    @Test
    @DisplayName("구입금액이 입력되는지 테스트")
    public void purchaseTest() {
        //given
        String input = "14000\n";
        systemIn(input);
        Input inputProcess = new Input();
        //when
        Integer price = inputProcess.readPrice();
        //then
        Assertions.assertThat(price).isEqualTo(14000);
    }

    @Test
    @DisplayName("당첨번호의 입력 테스트")
    public void lengthTest() {
        //given
        String input = "1, 2, 3, 4, 5, 6\n";
        systemIn(input);
        Input inputProcess = new Input();
        //when
        List<Integer> lastLottoNumbers = inputProcess.readLastLottoNumbers();
        //then
        Assertions.assertThat(lastLottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 당첨번호 입력 테스트")
    public void bonusNumberInputTest() {
        //given
        String input = "7\n";
        systemIn(input);
        Input inputProcess = new Input();
        //when
        Integer bonusNumber = inputProcess.readBonusNumber();
        //then
        Assertions.assertThat(bonusNumber).isEqualTo(7);
    }

    public void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
