package tests;

import org.junit.jupiter.api.*;
import sample.Controller;

import java.util.ArrayList;

/**
 * Данный класс является юнит тестом
 * @author Кузнецов Михаил Пи19-4
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestApplication {
    private Controller controller;

    /**
     * Этот метод выполняется перед каждым началом нового теста
     * Тут происходит инициализация объекта.
     */
    @BeforeAll
    public void beforeTesting(){
        controller = new Controller();
    }

    /**
     * Данный метод проверяет заполнился ли ArrayList значениями
     * Если да, то тест успешно выполняется.
     */
    @Test
    public void testGetYourNumbers(){
        ArrayList<Integer> arrayList = controller.getYourNumbers(10,100);
        Assertions.assertFalse(arrayList == null);
        System.out.println("Тест успешно пройден!");
    }

    /**
     * Данный метод выполняется после выполнения каждого теста
     * Тут закрывается объект, то есть, ему присваивается null, он становится пустым.
     */
    @AfterAll
    public void afterTesting(){
        controller = null;
    }
}
