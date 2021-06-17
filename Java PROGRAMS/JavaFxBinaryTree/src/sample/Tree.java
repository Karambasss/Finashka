package sample;

/**
 * Данный класс представляет собой бинарное дерево, тут происходит вставка новых веток, а также поиск указанной ветки по данным.
 * @author Кузнецов Михаил Пи19-4
 */
public class Tree {
    private Node rootNode;

    /**
     * Конструктор для заполнения ядра ветки (самой главной, начальной ветки).
     */
    public Tree(){
        rootNode = null;
    }

    /**
     * Данный метод производит вставку новой ветки в бинарное дерево.
     * @param data Данные, которые требуются вставить в бинарное дерево.
     * @return True/False - буленовское число, в случае успешной вставки будет возвращено true, в обратном случае false.
     */
    public boolean insert(int data){
        Node newNode = new Node();
        newNode.setData(data);
        if (rootNode == null){
            rootNode = newNode;
            return true;
        }
        else {
            Node currentNode = rootNode;
            Node parentNode;
            while (true){
                parentNode = currentNode;
                if (data == currentNode.getData()){
                    System.out.println("Повтор!");
                    return false;
                }
                else if (data < currentNode.getData()){
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null){
                        parentNode.setLeftChild(newNode);
                        return true;
                    }
                }
                else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null){
                        parentNode.setRightChild(newNode);
                        return true;
                    }
                }
            }
        }
    }

    /**
     * Данный метод производит поиск нужной ветки по указанным данным.
     * @param value Переданные данные по которым находится нужная ветка.
     * @return Ветка, в случае если она нашлась, в обратном случае будет возвращено null.
     */
    public Node findNodeByValue(int value){
        Node currentNode = rootNode;
        while (currentNode.getData() != value){
            if (value < currentNode.getData()){
                currentNode = currentNode.getLeftChild();
            }
            else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null){
                return null;
            }
        }
        return currentNode;
    }
}
