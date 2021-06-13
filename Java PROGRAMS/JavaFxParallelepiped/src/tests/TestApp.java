package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.Controller;

public class TestApp {
    private Controller controller;

    @Before
    public void beforeTesting(){
        controller = new Controller();
    }

    @Test
    public void testGetVolume(){
        int res = controller.getVolume(5,10,15);
        Assert.assertEquals(750,res);
        System.out.println("Вы успешно прошли тест: testGetVolume!");
    }
    @Test
    public void testGetVolume2(){
        int res = controller.getVolume(5,10,15);
        Assert.assertFalse(700 == res);
        System.out.println("Вы успешно прошли тест на неверное выражение: testGetVolume2");
    }
    @After
    public void afterTesting(){
        controller = null;
    }
}
