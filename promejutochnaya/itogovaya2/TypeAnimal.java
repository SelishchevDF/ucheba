
import java.util.Date;
import java.util.List;

public class TypeAnimal extends Animal {

    protected String type;

    public TypeAnimal(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);

    }

    public TypeAnimal(String name, Date birthday) {
        super(name, birthday);

    }

    public String getType() {
        return type;
    }

}
