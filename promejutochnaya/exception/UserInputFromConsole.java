import java.util.Scanner;

public class UserInputFromConsole {

    Scanner input = new Scanner(System.in,"utf-8");
   
    public String inputString(String invate){
        String key;
        System.out.println(invate);
        key = input.nextLine();
        return key;
    }
}