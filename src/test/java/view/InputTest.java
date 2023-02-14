package view;

import domain.BonusNumber;
import domain.InputPrice;
import domain.LastLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {
    @Test
    @DisplayName("구입금액이 입력되는지 테스트")
    public void purchaseTest() {
        String input = "14000\n";
        systemIn(input);
        Input inputProcess = new Input();
        InputPrice inputPrice = inputProcess.readPrice();
        assertThat(inputPrice.getPrice()).isEqualTo(14000);
    }

    @Test
    @DisplayName("당첨번호의 입력 테스트")
    public void lengthTest() {
        String input = "1, 2, 3, 4, 5, 6\n";
        systemIn(input);
        Input inputProcess = new Input();
        LastLottoNumbers lastLottoNumbers = inputProcess.readLastLottoNumbers();
        assertThat(lastLottoNumbers.getLastLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 당첨번호 입력 테스트")
    public void bonusNumberInputTest() {
        String input = "7\n";
        systemIn(input);
        Input inputProcess = new Input();
        BonusNumber bonusNumber = inputProcess.readBonusNumber();
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    public void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}