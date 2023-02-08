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
        String input = "14000\n";
        systemIn(input);
        Input inputProcess = new Input();
        Integer price = inputProcess.readPrice();
        Assertions.assertThat(price).isEqualTo(14000);
    }

    @Test
    @DisplayName("입력된 당첨번호의 길이가 6인지 테스트")
    public void lengthTest() {
        String input = "1, 2, 3, 4, 5, 6\n";
        systemIn(input);
        Input inputProcess = new Input();
        List<Integer> lastLottoNumbers = inputProcess.readLastLottoNumbers();
        Assertions.assertThat(lastLottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 당첨번호가 입력되는지 테스트")
    public void bonusNumberInputTest() {
        String input = "7\n";
        systemIn(input);
        Input inputProcess = new Input();
        Integer bonusNumber = inputProcess.readBonusNumber();
        Assertions.assertThat(bonusNumber).isEqualTo(7);
    }

    public void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}