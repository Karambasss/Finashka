package sample;

/**
 * Данный класс является самой веткой бинарного дерева.
 * @author Кузнецов Михаил Пи19-4
 */
public class Node {
    private int data; // полезное, то, что мы храним

    private Node leftChild;
    private Node rightChild;

    /**
     * Данный метод возвращает информацию о текущей ветке (иноформация о значении ветки и ее соседей)
     * @return Сообщение о текущей ветке.
     */
    @Override
    public String toString(){

        if (leftChild == null && rightChild == null){
            return "Node {" + "value = " + data + ", leftChildValue = no" + ", rigthChildValue = no }";
        }
        if (leftChild == null && rightChild != null){
            return "Node {" + "value = " + data + ", leftChildValue = no" + ", rigthChildValue = " +  rightChild.data  +"}";
        }
        if (rightChild == null && leftChild != null){
            return "Node {" + "value = " + data + ", leftChildValue = " + leftChild.data + ", rigthChildValue = no }";
        }
        return "Node {" + "value = " + data + ", leftChildValue = " + leftChild.data +  ", rigthChildValue = " +  rightChild.data  +"}";
    }

    /**
     * Геттер для получения данных ветки.
     * @return data - данные ветки.
     */
    public int getData() {
        return data;
    }

    /**
     * Сеттер, для того чтобы присвоить данным новые, переданные из параметра пользователем данные.
     * @param data Новые данные
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Геттер для получения поля ветки соседней.
     * @return Левая соседняя ветка.
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     * Сеттер для того, чтобы присвоить новые данные к левой соседней ветке
     * @param leftChild Новые данные
     */
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Геттер для получения поля правой соседней ветки
     * @return Правая соседняя ветка
     */
    public Node getRightChild() {
        return rightChild;
    }

    /**
     * Сеттер для того, чтобы присвоить новые данные к правой соседней ветке
     * @param rightChild Новые данные
     */
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
