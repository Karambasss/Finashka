import java.util.ArrayList;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        User user = new User();

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

//        Scanner scanner = new Scanner(System.in);
//        System.out.printf("Введите кол-во ходов: ");
//        int turns = scanner.nextInt(); //Количество заполнений
//        for (int i = 0; i < turns; i++){
//            System.out.print("Введите id + gender! ");
//            user.putIntoGenderMap(scanner.nextInt(),scanner.next());
//            System.out.print("Введите id + name! ");
//            user.putIntoNameMap(scanner.nextInt(),scanner.next());
//            System.out.print("Введите id + age! ");
//            user.putIntoAgeMap(scanner.nextInt(), scanner.nextInt());
//        }

        user.getUserByGender("male"); // находим по полу мужчина
        user.getAllUsersAndAllGenders();// красивая инфа о всех пользователей и полов

        System.out.println("Первый способ получения кол-ва пользователей!");
        int numberOfUsers = user.NumberOfUsersByNames();
        System.out.println("Количество пользователей: " + numberOfUsers);
        System.out.println("Второй способ получения кол-ва пользователей по именам пользователей!");
        ArrayList<Integer> userIdList = user.getAllUsersByNames();
        int numOfUsersByNames = user.NumberOfUsersByArray(userIdList);
        System.out.println("Количество пользователей: " + numOfUsersByNames);

        System.out.println("Количество пользователей по выбранному полу!");
        int numOfUsersByGenderMale = user.getNumOfUsersByGender("male");
        System.out.println("Количество мужчин: " + numOfUsersByGenderMale);

        int numOfUsersByGenderFemale = user.getNumOfUsersByGender("female");
        System.out.println("Количество женщин: " + numOfUsersByGenderFemale);

        ArrayList<Integer> usersID = user.getArrayOfUsersByGenders("male"); // присылаем все айди по полу мужчина
        System.out.println("Находим имена мужчин: ");
        user.genderToString(usersID); // отдаем инфу об имени человека по айди с полом мужчина

        System.out.println("Анализ возрастов");
        ArrayList<Integer> usersIDbyAge = user.getAllUsersByAge(); //все айди всех users

        double average = user.getAverageAgeByUsers(usersIDbyAge); // среднее по возрастам
        System.out.println("Средний возраст!");
        System.out.println(average);

        double averageByGenderMale = user.getAverageByGender("male", usersIDbyAge); // среднее по возрастам по указанном полу
        System.out.println("Средний возраст мужчин!");
        System.out.println(averageByGenderMale);

        double averageByGenderFemale = user.getAverageByGender("female", usersIDbyAge); // среднее по возрастам по указанном полу
        System.out.println("Средний возраст женщин!");
        System.out.println(averageByGenderFemale);
    }
}
