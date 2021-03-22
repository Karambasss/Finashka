package sample;

public class Users {
    public boolean locker = false;
    public int age;
    public String name;
    public String surname;
    //public int id; # Тк у нас это автоинкремент мы не будем создавать данное поле

    public Users(String name, int age, String surname){
        try{
            if (!(name.isEmpty()) && !(surname.isEmpty())){
                this.name = name;
                this.age = age;
                this.surname = surname;
                this.locker = true;
            }
        }
        catch (Exception e){
            System.out.println("Mistake");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
