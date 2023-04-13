import java.util.Scanner;

public class UserInputFromConsole {

    Scanner input = new Scanner(System.in);
   
    public String inputString(String invate){

        String key;
        System.out.print(invate);
        key = input.nextLine();
        return key;
    }

}
