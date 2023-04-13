import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CreateAnimal {
    
    private static List<String> parseAnimalSpec(String string){

        List<String> result = new ArrayList<String>(Arrays.asList(string.split(" ")));

        return result;
    }

    public static SubTypeAnimal createAnimal (String string){

        SubTypeAnimal result = new SubTypeAnimal("-1", new Date());

        List<String> list = parseAnimalSpec(string);
        if (list.size() !=3 ) System.out.println("животное не завелось \n");// 3 - передавать 3 аргумента субтип, имя, день рождения
        else{
            String subType = list.get(0);
            String name = list.get(1);
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date birthDay = new Date();
            try {
                birthDay = (formatter.parse(list.get(2)));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                System.out.println("неправильный формат даты \n");
            }

            if (subType.equals("cat")){
                Cat a = new Cat(name, birthDay);
                result = a;
            }
            if (subType.equals("dog")){
                Dog a = new Dog(name, birthDay);
                result = a;
            }
            if (subType.equals("hamster")){
                Hamster a = new Hamster(name, birthDay);
                result = a;
            }
            if (subType.equals("horse")){
                Horse a = new Horse(name, birthDay);
                result = a;
            }
            if (subType.equals("camel")){
                Camel a = new Camel(name, birthDay);
                result = a;
            }
            if (subType.equals("donkey")){
                Donkey a = new Donkey(name, birthDay);
                result = a;
            }
        }
        
        return result;
    }
}
