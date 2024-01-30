
//Напишите программу, которая использует Stream API для обработки списка чисел.
//Программа должна вывести на экран среднее значение всех четных чисел в списке.

package lesson1.t1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main{

    private static final int SIZE = 10;
    private static Random r = new Random();

    public static void main(String[] args) {
        
        List <Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < SIZE; i++){
            list.add(r.nextInt(SIZE));
        }

        System.out.println(list);

        System.out.println(list.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum)/
            list.stream().filter(x -> x % 2 == 0).count());
    }
}