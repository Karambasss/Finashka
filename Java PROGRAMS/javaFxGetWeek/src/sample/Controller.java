package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.IsoFields;
import java.util.Date;

/**
 * Класс Controller для работы с JavaFx
 * @author Кузнецов Михаил Пи19-4
 */
public class Controller {
    @FXML
    TextField resultField;
    @FXML
    Button clickButton;
    @FXML
    DatePicker yourDate;

    /**
     * Данный метод выполняет наахождение номера недели
     * @param year год, от даты, введенной пользователем (необходим для нахождения стартового времени - 1 января года который вы передали)
     * @param date дата, которую ввел пользователь (это нужно для нахождения разницы между введенным годом и датой - сколько прошло миллисекунд между 01.01.год,переданный пользователей и датой, введенной пользователем).
     * @return result - номер недели.
     */
    public byte getYourWeek(int year, LocalDate date){

        Date start = null;
        try {
            start = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year); // сегодняшний год начала
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        long yourDateInMillis = date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli(); // время, введенное пользователем в мс
        long startInMillis = start.getTime(); // стартовое время от 01.01. .... в миллисекундах
        int timeOfTheWeekInMillis = 1000 * 60 * 60 * 24 * 7; // неделя в миллисекундах

        byte result = (byte) Math.round((double)(yourDateInMillis - startInMillis) / timeOfTheWeekInMillis); // разница от времени ввденным пользователем - старт время / 1 неделю в мсекундах и округляем в большую сторону.
        return result;
    }
    /**
     * Данный метод обрабатывает нажатие на кнопку, отдает во view пользователя номер недели.
     */
    public void clickMe(){
        resultField.clear(); //чистим филд от прошлого ответа при новом нажатии на кнопку.

        LocalDate date = yourDate.getValue(); // получаем дату, которую пользователь ввел.


        int weekNumber = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);

        int yourYear = date.getYear(); // год, который пользователь ввел по дате находим.


        byte yourWeek = getYourWeek(yourYear, date); // получаем номер недели.

        resultField.setText("Ответ: " + weekNumber); // вставляем в resultField.
    }
}
