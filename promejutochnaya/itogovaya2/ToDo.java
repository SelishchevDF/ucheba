import java.util.ArrayList;
import java.util.List;

public class ToDo {

    List<SubTypeAnimal> animals = new ArrayList<SubTypeAnimal>();
    Schetchik s = new Schetchik();

    public void doSomething(String userSelect){

        UserInputFromConsole input = new UserInputFromConsole();

        if (userSelect.equals("1")) {
            // посмотреть всех животных
            System.out.println();
            if (animals.size() != 0){
                for (SubTypeAnimal a : animals) {
                    System.out.println(a.getSubType() + " " + a.getName() + " " + a.getBirthdayFormatted() + "\n");
                }
            }
            else System.out.println("никого нет \n");
        }
        
        else if (userSelect.equals("2")) {
            //добавить животное
            System.out.println();
            String str = input.inputString("ВВедите через пробел подкласс животного - "+
                                                "(cat, dog, hamster, horse, camel, donkey)," +
                                                "кличку животного," +
                                                "дату рождения животного в формате dd.MM.yyyy \n");
            SubTypeAnimal a = CreateAnimal.createAnimal(str);
            if (a.getName().equals("-1")) System.out.println("что то пошло не так \n");
            else animals.add(a);
            s.add();
            System.out.println();
            System.out.println("заведено животное - " + a.getName() + "\n");
        }
    
        else if (userSelect.equals("3")) {
            // добавить комманду
            if (animals.size() == 0) System.out.println("Животных нет\n");
            else {
                String str = input.inputString("ВВедите кличку кого учить \n");
                int i = 0;
                for (SubTypeAnimal a : animals) {
                    if (a.getName().equals(str)) {
                        str = input.inputString("ВВедите чему учить \n");
                        a.addCommand(str);
                        i++;
                        System.out.println(a.getName() + " обучился " + str + "\n");
                    }
                if (i == 0) System.out.println("Животное не найдено\n");
                }
            }
            
        }

        else if (userSelect.equals("4")) {
            // посмотреть комманды животного
            if (animals.size() == 0) System.out.println("Животных нет\n");
            else {
                String str = input.inputString("ВВедите кличку \n");
                int i = 0;
                for (SubTypeAnimal a : animals) {
                    if (a.getName().equals(str)) {
                        System.out.println();
                        System.out.println(a.getName() + " - " + a.getCommands() +"\n");
                        i++;
                    }
                if (i == 0) System.out.println("Животное не найдено\n");
                }
            }
        }
    }    
}