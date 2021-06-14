package tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.Controller;

import java.io.File;

public class TestApplication {
    private Controller controller;
    @Before
    public void beforeTest(){
        controller = new Controller();
    }
    @After
    public void afterTest(){
        controller = null;
    }
    @Test
    public void testGetAverage(){
        File file = new File("C:\\Users\\mpapa\\IdeaProjects\\JavaFxSrFile\\src\\files\\myfile.txt");
        double result = controller.getAverage(file);
        Assert.assertEquals(15.4,result,0);
        System.out.println("Тест testGetAverage успешно пройден!");
    }
    @Test
    public void testNotGetAverage(){
        File file = new File("C:\\Users\\mpapa\\IdeaProjects\\JavaFxSrFile\\src\\files\\myfile.txt");
        double result = controller.getAverage(file);
        Assert.assertFalse(16 == result);
        System.out.println("Тест на неправильное значение testNotGetAverage успешно пройден!");
    }
}
