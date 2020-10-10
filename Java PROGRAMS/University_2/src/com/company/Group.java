package com.company;

public class Group {
    private String group;
    private int kurs;
    public Group(String group, int kurs){
        if (group.length() > 0 && group.length() < 15) {
            this.group = group;
        }
        if (kurs > 0 && kurs <= 6)
        this.kurs = kurs;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }
    public void info(){
        System.out.println(" Номер группы: " + getGroup()+ "\n" +  " Номер курса: " + getKurs());
    }
}
