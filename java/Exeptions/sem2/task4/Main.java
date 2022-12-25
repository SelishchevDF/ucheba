package sem2.task4;

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = in.nextLine();
        if(string.isEmpty())
            throw new IllegalArgumentException("Строка пустая!");
        else
            System.out.println("Строка - " + string);
        in.close();
    }
}