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
    public void testFact(){
        int res = controller.Fact(5);
        Assertions.assertEquals(120,res);
        System.out.println("Вы успешно прошли тест: testFact!");
    }
    @Test
    public void testFact2(){
        int res = controller.Fact(5);
        Assertions.assertFalse(24 == res);
        System.out.println("Вы успешно прошли тест: testFact2");
    }
    @AfterAll
    public void afterTesting(){
        controller = null;
    }
}
