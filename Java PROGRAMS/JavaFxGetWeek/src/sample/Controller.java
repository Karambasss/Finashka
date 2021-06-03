package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class Controller {
    @FXML
    TextField resultField;
    @FXML
    Button clickButton;
    @FXML
    DatePicker yourDate;

    public byte getYourWeek(int year, LocalDate date){

        Date start = null;
        try {
            start = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year); // сегодняшний год начала
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        long yourDateInMillis = date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli(); // время, введенное пользователем
        long startInMillis = start.getTime(); // стартовое время от 01.01. ....
        int timeOfTheWeekInMillis = 1000 * 60 * 60 * 24 * 7; // неделя в миллисекундах

        byte result = (byte) Math.round((double)(yourDateInMillis - startInMillis) / timeOfTheWeekInMillis); // разница от времени ввденным пользователем - старт время / 1 неделю в мсекундах и округляем в большую сторону.
        return result;
    }

    public void clickMe(){
        resultField.clear();

        LocalDate date = yourDate.getValue(); // получаем дату

        int yourYear = date.getYear(); // год, который пользователь ввел

        byte yourWeek = getYourWeek(yourYear, yourDate.getValue());

        resultField.setText("Ответ: " + yourWeek);
    }
}
