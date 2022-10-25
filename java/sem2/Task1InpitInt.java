import java.util.Scanner;

public class Task1InpitInt{

    public static boolean chekIntNum(String inputedString) { 

        try {
            Integer.parseInt(inputedString);
            return true;     
        } 
        catch (Exception e) {
            return false;
        }
    }

    public static int inputNum(String stringInvatation, String stringError) {

        String inputStr = null;
        Scanner input = new Scanner(System.in);
        Boolean condition = false;
        int num = 0;

        while (condition == false) {
            System.out.println(stringInvatation);
            inputStr = input.nextLine();
            if (chekIntNum(inputStr) == true && Integer.parseInt(inputStr) > 0){
                condition = true;
                num = Integer.parseInt(inputStr);
            }
            else{
                System.out.println(stringError);
            }
        }
        input.close();
        return num;
    }
}



