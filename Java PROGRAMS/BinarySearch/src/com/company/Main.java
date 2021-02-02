package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] generate(int lenght){

        int[] array = new int[lenght];

        for (int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * 1000);
        }

        return array;
    }

    public static int Binary_Search(int[] sortedArray, int key, int lowest, int highest){

        int middle = (lowest + highest) / 2;

        if (lowest > highest){
            System.out.println("Элемент не найден в этом массиве");
            return -1;
        }

        if (key == sortedArray[middle]){
            System.out.println("Элемент в массиве найден, вот его индекс");
            return middle;
        }

        else if (key > sortedArray[middle]){
            return Binary_Search(sortedArray, key,middle + 1, highest);
        }

        else{
            return Binary_Search(sortedArray, key, lowest, middle - 1);
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner Scan = new Scanner(System.in);

        int[] array = generate(Scan.nextInt());

        // Для бин поиска делаем сортировку

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++){
            System.out.print(i + "  ");
        }

        System.out.println();

        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();

        System.out.println("Введите число, которое хотите найти в массиве! " );

        int key = Scan.nextInt();

        System.out.println(Binary_Search(array, key, 0 , array.length - 1));

    }
}
