public class Menu {

    private static UserInputFromConsole scan = new UserInputFromConsole();
    private static String userSelect = "EMPTY";
    private static ToDo toDo = new ToDo();

    public static void Start(){

        while (!userSelect.equals("q")){
            userSelect = "EMPTY";
            userSelect = scan.inputString("1 - посмотреть животных \n"+
                                                "2 - завести животное \n"+
                                                "3 - обучить животное комманде \n"+
                                                "4 - посмотреть комманды \n"+
                                                "q- выход \n");
            toDo.doSomething(userSelect);
          
        }

        scan.input.close();
        System.out.println("Пока!");
    }
}