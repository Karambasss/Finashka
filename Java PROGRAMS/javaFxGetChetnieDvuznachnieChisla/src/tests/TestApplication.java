package tests;

import org.junit.jupiter.api.*;
import sample.Controller;

import java.util.ArrayList;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestApplication {
    private Controller controller;
    @BeforeAll
    public void beforeTesting(){
        controller = new Controller();
    }
    @Test
    public void testGetYourNumber(){
        ArrayList<Integer> arrayList = controller.getYourNumbers(100,10);
        Assertions.assertFalse(arrayList == null);
        System.out.println("Успешно пройден тест");
    }
    @AfterAll
    public void afterTesting(){
        controller = null;
    }
}
