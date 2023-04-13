
import java.util.Date;
import java.util.List;

public class SubTypeAnimal extends TypeAnimal {

    protected String subType;

    public SubTypeAnimal(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);

    }

    public SubTypeAnimal(String name, Date birthday) {
        super(name, birthday);
    }

    public String getSubType() {
        return subType;
    }

    public String getSubTypeAnimal(){
        String result = "";

        result = getSubType() + " " + getName() + " " + getBirthday() + " Команды - " + getCommands();

        return result;
    }

}
