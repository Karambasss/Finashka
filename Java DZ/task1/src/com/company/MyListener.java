package com.company;

public class MyListener implements ChangeListener{

    @Override
    public void onChange(OvservableStringBuilder stringBuilder) {
        System.out.println("CHANGED: " + stringBuilder.toString());
    }
}
