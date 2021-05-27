import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void initTest(){
        user = new User();
        user.putIntoGenderMap(1, "male");
        user.putIntoNameMap(1, "misha");
        user.putIntoAgeMap(1, 15);

        user.putIntoGenderMap(2, "male");
        user.putIntoNameMap(2, "genry");
        user.putIntoAgeMap(2, 25);

        user.putIntoGenderMap(3, "female");
        user.putIntoNameMap(3, "masha");
        user.putIntoAgeMap(3, 30);

        user.putIntoGenderMap(4, "female");
        user.putIntoNameMap(4, "sonya");
        user.putIntoAgeMap(4, 5);
    }

    @After
    public void afterTest(){
        user = null;
    }

    @Test
    public void testGetAverage() {
        ArrayList<Integer> agesID = user.getAllUsersByAge();
        double actual = user.getAverageAgeByUsers(agesID);
        assertEquals(18.75, actual,0);
        System.out.println("Вы успешно прошли тест: #testGetAverage!");
    }

    @Test
    public void testGetAverageAgeByGenderMale() {
        ArrayList<Integer> agesID = user.getAllUsersByAge();
        double actual = user.getAverageByGender("male", agesID);
        assertEquals(20.0, actual,0);
        System.out.println("Вы успешно прошли тест: #testGetAverageAgeByGenderMale!");
    }

    @Test
    public void testGetAverageAgeByGenderFemale(){
        ArrayList<Integer> agesID = user.getAllUsersByAge();
        double actual = user.getAverageByGender("female", agesID);
        assertEquals(17.5,actual,0);
        System.out.println("Вы успешно прошли тест: #testGetAverageAgeByGenderFemale!");
    }

    @Test
    public void testNumberOfUsersByNames(){
        assertEquals(4,user.NumberOfUsersByNames());
        System.out.println("Вы успешно прошли тест: #testNumberOfUsersByNames!");
    }

    @Test
    public void testNumberOfUsersByArray(){
        ArrayList<Integer> userIdList = user.getAllUsersByNames();
        assertEquals(4, user.NumberOfUsersByArray(userIdList));
        System.out.println("Вы успешно прошли тест: #testNumberOfUsersByArray!");
    }

    @Test
    public void testGetNumOfUsersByGenderMale(){
        assertEquals(2, user.getNumOfUsersByGender("male"));
        System.out.println("Вы успешно прошли тест: #testGetNumOfUsersByGenderMale!");
    }

    @Test
    public void testGetNumOfUsersByGenderFemale(){
        assertEquals(2,user.getNumOfUsersByGender("female"));
        System.out.println("Вы успешно прошли тест: #testGetNumOfUsersByGenderFemale!");
    }
}