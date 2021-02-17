package com.company;

public class Human {
    private String name;

    private int age;

    private String gender;

    private int salary;

    public Human(String name, int age, String gender, int salary){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private void getInformation(){
        System.out.println("Это Человек, его имя: " + getName() + ", его возраст: " + this.age + ", его пол: " + this.gender + ", ЗП = " + this.salary);
    }

    public void insertPassToUse_getInformation(String pass){
        String password = "222456";
        if ( pass.equals(password) ){
            System.out.println("Теперь вы знаете больше об этом человеке!");
            getInformation();
        }
        else {
            System.out.println("Попробуйте снова, это не тот код доступа");
        }
    }
}
