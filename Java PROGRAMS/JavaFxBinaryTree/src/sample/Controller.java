package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Данный класс создан для работы с javaFx
 * @author Кузнецов Михаил Пи19-4
 */
public class Controller {
    @FXML
    TextField insert_fld;
    @FXML
    TextField search_fld;
    @FXML
    TextArea result_fld;

    Tree tree = new Tree();

    /**
     * Данный метод находит ветку по параметру, переданному пользователем.
     * @param data Полученные данные
     * @return Возвращает ветку
     */
    public Node searchFunc(int data){
        Node node = tree.findNodeByValue(data);
        return node;
    }

    /**
     * Данный метод обрабатывает нажатие на кнопку insert/добавить, в качестве вывода ответа пользователь получит сообщение о добавлении или не добавлении ветки.
     */
    @FXML
    public void clickToInsert(){
        result_fld.clear();
        try {
            int data = Integer.parseInt(insert_fld.getText());
            boolean result = tree.insert(data);
            Alert alert;
            if (result){
                alert = new Alert(Alert.AlertType.INFORMATION, "Вы успешно добавили новую ветку!");
            }
            else {
                alert = new Alert(Alert.AlertType.ERROR, "Новая ветка не добавлена, тк. вы повторили значение ветки!");
            }
            alert.showAndWait();
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Вы ошиблись");
            alert.showAndWait();
        }
        insert_fld.clear();
    }

    /**
     * Данный метод обрабатывает нажатие на кнопку search/поиск, в качестве вывода, если пользователь нашел ветку по указанным данным, то ему будет выведено сообщение о искомой ветке и ее 2 соседей (левое и правое)
     */
    @FXML
    public void clickToSearch(){
        result_fld.clear();
        try {
            int data = Integer.parseInt(search_fld.getText());
            Node node = searchFunc(data);
            if (node != null){
                result_fld.setText(node.toString());
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR,"Не нашлась такая ветка!");
                alert.showAndWait();
            }
        }
        catch (NumberFormatException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Вы ошиблись");
            alert.showAndWait();
        }
        search_fld.clear();
    }
}
