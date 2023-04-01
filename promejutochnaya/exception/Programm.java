public class Programm {

    public static void main(String[] args){

    UserInputFromConsole scan = new UserInputFromConsole();
    String userString;
    String result[];

    userString = scan.inputString(CONST.INVATE);

    result = ParseAndSort.parseAndSortUseString(userString);
    SaveToTxt.saveAs(result);
    System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}