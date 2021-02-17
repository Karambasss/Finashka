package com.company;

public class Main {

    public static void main(String[] args) {

        OvservableStringBuilder UndoableStringBuilder = new OvservableStringBuilder();

        UndoableStringBuilder.setOnChangeListener(new MyListener());

        UndoableStringBuilder.append("Hello");

        UndoableStringBuilder.append(", ");

        UndoableStringBuilder.append("World!");
    }
}
