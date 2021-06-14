package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Данный класс создан для работы с javaFx
 * @author Кузнецов Михаил Пи19-4
 */
public class Controller {
    @FXML
    TextField re_fld;

    @FXML
    TextField im_fld;

    @FXML
    TextField re1_fld;

    @FXML
    TextField im1_fld;

    @FXML
    TextField res_fld;

    /**
     * Данный метод настраивает класс ComplexNumber, присваивает полям объекта значения из заполненного пользователем текстбокса
     * @param re число re, которое пользователь ввел в текстбоксе
     * @param im число, im, которое пользователь ввел в текстбоксе
     * @return Возвращает конструктор класса ComplexNumber для его создания
     */
    public ComplexNumber getYourRes(TextField re, TextField im){
        double reNew;
        double imNew;
        try {
            reNew = Double.parseDouble(re.getText());
            imNew = Double.parseDouble(im.getText());
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Ошибка ввода!");
            alert.showAndWait();
            return null;
        }
        return new ComplexNumber(reNew,imNew);
    }

    /**
     * Данный метод обрабатывает нажатие на кнопку плюс, в нем происходит сложение комплексных чисел, вывод ответа пользователь получит во view
     */
    @FXML
    public void plusClick(){
        res_fld.clear();
        ComplexNumber complexNumber = getYourRes(re_fld, im_fld);
        ComplexNumber complexNumber1 = getYourRes(re1_fld, im1_fld);
        if (complexNumber == null && complexNumber1 == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Произошла ошибка создания объекта");
            alert.showAndWait();
        }
        else {
            ComplexNumber resNumber = ComplexNumber.plus(complexNumber,complexNumber1);
            try {
                res_fld.setText("Ответ: " + resNumber.getRe() + " + " + resNumber.getIm() + "i");
            }
            catch (NullPointerException exception){
                System.out.println("Ошибка!");
            }
        }
//        re_fld.clear();
//        im_fld.clear();
//        re1_fld.clear();
//        im1_fld.clear();
    }

    /**
     * Данный метод обрабатывает нажатие на кнопку минус, в нем происхожит вычитание комплексных чисел, вывод ответа пользователь получит во view
     */
    @FXML
    public void minusClick(){
        res_fld.clear();
        ComplexNumber complexNumber = getYourRes(re_fld, im_fld);
        ComplexNumber complexNumber1 = getYourRes(re1_fld, im1_fld);
        if (complexNumber == null && complexNumber1 == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Произошла ошибка создания объекта");
            alert.showAndWait();
        }
        else {
            ComplexNumber resNumber = ComplexNumber.minus(complexNumber, complexNumber1);
            try {
                res_fld.setText("Ответ: " + "( " + resNumber.getRe() + " ) " + " + " + "( " + resNumber.getIm() + "i" + " )");
            }
            catch (NullPointerException exception){
                System.out.println("Ошибка!");
            }
        }
//        re_fld.clear();
//        im_fld.clear();
//        re1_fld.clear();
//        im1_fld.clear();
    }

    /**
     * Данный метод обрабатывает нажатие на кнопку умножить, в нем происходит умножение комплексных чисел, вывод ответа пользовать получит во view
     */
    @FXML
    public void multipClick(){
        res_fld.clear();
        ComplexNumber complexNumber = getYourRes(re_fld,im_fld);
        ComplexNumber complexNumber1 = getYourRes(re1_fld,im1_fld);
        if (complexNumber == null && complexNumber1 == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Произошла ошибка создания объекта");
            alert.showAndWait();
        }
        else {
            ComplexNumber resNumber = ComplexNumber.multiply(complexNumber,complexNumber1);
            try {
                res_fld.setText("Ответ: " + resNumber.getRe() + " + " + resNumber.getIm() + "i");
            }
            catch (NullPointerException exception){
                System.out.println("Ошибка");
            }
        }
//        re_fld.clear();
//        im_fld.clear();
//        re1_fld.clear();
//        im1_fld.clear();
    }
}
