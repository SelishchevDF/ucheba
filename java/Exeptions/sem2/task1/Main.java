package sem2.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean boolean1 = false  ;
        Float res = null;

        System.out.println("Введите дробь");
        while(!boolean1){
            try {
                Scanner s = new Scanner(System.in);
                res = s.nextFloat();
                boolean1 = true;
                s.close();
            } catch (Exception e) {
                System.out.println("Введите дробь правильно");
            }
        }
        System.out.println("Вы ввели - " + res);
        
    }
}