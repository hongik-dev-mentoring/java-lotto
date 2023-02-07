package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class LottoControllerTest {
    
    LottoController lottoController;


    @BeforeEach
    public void inputSetUp() {
        String input = "13999";
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