import java.util.Scanner;

public class UserInputFromConsole {

    Scanner input = new Scanner(System.in);
   
    public String inputString(String invate){

        String key;
        System.out.print(invate);
        key = input.nextLine();
        return key;
    }

    public int inputInt(String invate, String parseIntError){
        int key = 0;
        int flag = 0;
        while (flag != 1) {
            System.out.print(invate);
            try {
                key = Integer.parseInt(input.nextLine());
                flag = 1;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.print(parseIntError);
            }
        }
        return key;
    }
}
