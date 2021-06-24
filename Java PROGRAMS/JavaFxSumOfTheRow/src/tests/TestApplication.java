package tests;

import org.junit.jupiter.api.*;
import sample.Controller;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestApplication {
    private Controller controller;

    @BeforeAll
    public void beforeTesting(){
        controller = new Controller();
    }
    @Test
    public void testGetSumOfTheRow(){
        double result = controller.sumOfTheRow(6);
        Assertions.assertEquals(2.225,result,0.0000000000005);
        System.out.println("Тест успешно пройден: testGetSumOfTheRow");
    }
    @Test
    public void testNotGetSumOfTheRow(){
        double result = controller.sumOfTheRow(6);
        Assertions.assertFalse(2.22500000000000015 == result);
        System.out.println("Тест успешно пройден: testNotGetSumOfTheRow");
    }
    @AfterAll
    public void afterTesting(){
        controller = null;
    }

}
