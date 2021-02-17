package com.company;

public class OvservableStringBuilder {
    private ChangeListener onChangeListener;

    private StringBuilder stringBuilder;

    public void setOnChangeListener(ChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    public OvservableStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    private void notifyOnStringBuilderChangeListener(){
        if(onChangeListener != null){
            onChangeListener.onChange(this);
        }
    }

    public OvservableStringBuilder append(Object obj) {
        stringBuilder.append(obj);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public OvservableStringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public OvservableStringBuilder insert(int index, char[] str, int offset, int len) {
        stringBuilder.insert(index, str, offset, len);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }

    public ChangeListener getOnChangeListener() {
        return onChangeListener;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }
}
