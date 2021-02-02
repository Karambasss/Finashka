package com.company;

public class Vector {
    private int x;
    private int y;
    private int z;
    public Vector(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double getKoren(){
        int summa = x*x + y*y +z*z;
        double koren = Math.sqrt(summa);
        return koren;
    }
    public int getScalar(Vector vector1){ // на вход посылается новый вектор Vector vector1, который мы создадим из мейна, в котором будет лежать объект класса Вектор, с доступом к полям методам и тп в классе Вектор
        int skalar = this.x * vector1.x + this.y * vector1.y + this.z * vector1.z; // считается скалярная сумма векторов, записывается в skalar и возвращается число
        return skalar;
    }
    public Vector getVectornoe(Vector vector){ // задаем тип вектор, получающий на вход объект типа вектора, в котором будут все метолды и тп из объекта вектора
        // берем 2 вектора и соединяем их резульаты вычислений в третий вектор, который будет возвращать конструктор из 3 параметров, которые мы получили из 3 вычислений с нашими 2 векторами
        int vect1 = (this.y * vector.z) + ( this.z * vector.y);
        int vect2 = (this.z * vector.x) + (this.x * vector.z);
        int vect3 = (this.x * vector.y) + (this.y * vector.x);
        return new Vector(vect1,vect2,vect3); // выводится конструктор контсруктор возвращает объект класса и заполняет поля класса
    }
    public double getUgol(Vector vector){
        int chisl = getScalar(vector); // тут скалярное произведение этих 2 векторов, исходного и заданного в парметры
        double znam = vector.getKoren() * getKoren(); // тут мы берем корень из нового (заданного из параметров вектора) умноженное на наш вектор, с которым мы работаем
        double otvet = Math.acos(chisl / znam);
        return otvet;
    }
    public Vector getPlus(Vector vector){
        int vect1 = this.x + vector.x;
        int vect2 = this.y + vector.y;
        int vect3 = this.z + vector.z;
        return new Vector(vect1,vect2,vect3);
    }
    public Vector getMinus(Vector vector){
        int vect1 = this.x - vector.x;
        int vect2 = this.y - vector.y;
        int vect3 = this.z - vector.z;
        return new Vector(vect1,vect2,vect3);
    }
    public void info(){
        System.out.println("{" + x + ";" + y + ";" + z + "}");
    }

}
