package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class LottoControllerTest {
    
    LottoController lottoController;

    @BeforeEach
    public void inputSetUp() {
        String input = "14000\n1, 2, 3, 4, 5, 6\n7\n";
        systemIn(input);
    }

    public void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        lottoController = new LottoController();
    }

    @Test
    @DisplayName("LottoList 생성 테스트")
    void lottoListCreateTest() {
        lottoController.startLotto();
    }
    

}