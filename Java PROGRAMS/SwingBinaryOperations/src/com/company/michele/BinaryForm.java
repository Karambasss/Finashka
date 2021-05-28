package com.company.michele;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryForm {
    private JPanel binaryPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton ANDButton;
    private JButton ORButton;
    private JButton XORButton;
    private JButton NOTButton;
    private JButton RightSdvigButton;
    private JButton LeftSdvigButton;
    private JLabel resultLabel;

    public BinaryForm(){ //конструктор для заполнения полей объекта

        RightSdvigButton.addActionListener(e -> {
            try{
                int yourNum = Integer.parseInt(textField1.getText()); // Число, которое хотят сдвинуть
                int sdvig = Integer.parseInt(textField2.getText()); // сдвиг

                int yourNumAfterSdvig = yourNum >> sdvig; // число в десятичной системе счисления после сдвига вправо на указанное кол-во бит
                String yourBinaryNumAfterSdvig = Integer.toBinaryString(yourNumAfterSdvig); //число в двоичной системе счислени после сдвига вправо на указанное кол-во бит

                resultLabel.setText("Ваше  число после сдвига вправо: " + "         " + " В ДЕСЯТИЧНОЙ С.СЧ: " + yourNumAfterSdvig + "           " + " В ДВОИЧНОЙ С.СЧ: " + yourBinaryNumAfterSdvig);
            }
            catch (NumberFormatException exception){
                exception.printStackTrace();
                resultLabel.setText("Неправильный ввод!");
            }
        });
        LeftSdvigButton.addActionListener(e -> {
            try {
                int yourNum = Integer.parseInt(textField1.getText()); // Число, которое хотят сдвинуть
                int sdvig = Integer.parseInt(textField2.getText());  // сдвиг

                int yourNumAfterLeftSdvig = yourNum << sdvig; // число в десятичной системе счисления после сдвига влево на указанное кол-во бит
                String yourBinaryNumAfterLeftSdvig = Integer.toBinaryString(yourNumAfterLeftSdvig); // число в двоичной системе счисления после сдвига влево на указанное кол-во бит

                resultLabel.setText("Ваше число после сдвига влево: " + "          " + "В ДЕСЯТИЧНОЙ СЧ: " + yourNumAfterLeftSdvig + "            " + "В ДВОИЧНОЙ СЧ: " + yourBinaryNumAfterLeftSdvig);
            }
            catch (NumberFormatException exception){
                exception.printStackTrace();
                resultLabel.setText("Неправильный ввод!");
            }
        });
        ANDButton.addActionListener(e -> {
            try {
                int yourNum = Integer.parseInt(textField1.getText()); // первое число для побитового and
                int secondNum = Integer.parseInt(textField2.getText()); // второе число для побитового and

                int yourNumAfterBinaryAND = yourNum & secondNum; // результат выполнения бинарного AND в десятичной системе счисления
                String yourBinaryNumAfterBinaryAND = Integer.toBinaryString(yourNumAfterBinaryAND); // результат выполнения бинарного AND в двоичной системе счисления

                resultLabel.setText("Ваше число после побитового AND: " + "               " + "В ДЕСЯТИЧНОЙ СЧ: " + yourNumAfterBinaryAND + "               " + "В ДВОИЧНОЙ СЧ: " + yourBinaryNumAfterBinaryAND);
            }
            catch (NumberFormatException exception){
                exception.printStackTrace();
                resultLabel.setText("Неправильный ввод!");
            }
        });
        ORButton.addActionListener(e ->{
            try {
                int firstNum = Integer.parseInt(textField1.getText());
                int secondNum = Integer.parseInt(textField2.getText());

                int yourNumAfterBinaryOr = firstNum | secondNum;
                String yourBinaryNumAfterBinaryOr = Integer.toBinaryString(yourNumAfterBinaryOr);

                resultLabel.setText("Ваше число после побитового OR: " + "            " + "В ДЕСЯТИЧНОЙ СЧ: " + yourNumAfterBinaryOr + "               " + "В ДВОИЧНОЙ СЧ: " + yourBinaryNumAfterBinaryOr);
            }
            catch (NumberFormatException exception){
                exception.printStackTrace();
                resultLabel.setText("Неправильный ввод!");
            }
        });
        XORButton.addActionListener(e ->{
            try {
                int firstNum = Integer.parseInt(textField1.getText());
                int secondNum = Integer.parseInt(textField2.getText());

                int yourNumAfterBinaryXor = firstNum ^ secondNum;
                String yourBinaryNumAfterBinaryXor = Integer.toBinaryString(yourNumAfterBinaryXor);

                resultLabel.setText("Ваше число после побитового XOR: " + "              " + "В ДЕСЯТИЧНОЙ СЧ: " + yourNumAfterBinaryXor + "              " + "В ДВОИЧНОЙ СЧ: " + yourBinaryNumAfterBinaryXor);
            }
            catch (NumberFormatException exception){
                exception.printStackTrace();
                resultLabel.setText("Неправильный ввод!");
            }
        });
        NOTButton.addActionListener(e ->{
            try {
                int yourNum = Integer.parseInt(textField1.getText());

                int yourNumAfterBinaryNot = ~yourNum;
                String yourBinaryNumAfterBinaryNot = Integer.toBinaryString(yourNumAfterBinaryNot);

                resultLabel.setText("Ваше число после побитового NOT: " + "                 " + "В ДЕСЯТИЧНОЙ СЧ: " + yourNumAfterBinaryNot + "                      " + "В ДВОИЧНОЙ СЧ: " + yourBinaryNumAfterBinaryNot);
            }
            catch (NumberFormatException exception){
                exception.printStackTrace();
                resultLabel.setText("Неправильный ввод!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BinaryIT");
        frame.setContentPane(new BinaryForm().binaryPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(1000,500);
        frame.setVisible(true);
    }
}
