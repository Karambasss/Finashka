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
    public void testGetResistance(){
        int result = controller.getResistance(20,30);
        Assertions.assertEquals(50,result);
        System.out.println("Вы успешно прошли тест: testGetResistance!");
    }
    @Test
    public void testNotGetResistance(){
        int result = controller.getResistance(30,30);
        Assertions.assertFalse(70 == result);
        System.out.println("Вы успешно прошли тест: testNotGetResistance");
    }
    @AfterAll
    public void afterTesting(){
        controller = null;
    }
}
