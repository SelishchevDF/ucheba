public class Menu {



    private static UserInputFromConsole scan = new UserInputFromConsole();
    private static String userSelect = "EMPTY";
    private static ToDo toDo = new ToDo();



    public static void Start(){

        while (!userSelect.equals("q")){
            userSelect = "EMPTY";
            userSelect = scan.inputString(Texts.inviteMenu);
            toDo.doSomething(userSelect);           
        }

        scan.input.close();
        System.out.println("Пока!");
    }
}
