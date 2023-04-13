import java.util.Date;
import java.util.List;

public class Dog extends SubTypeAnimal {

    public Dog(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
        this.type = "pet";
        this.subType = "dog";

    }

    public Dog(String name, Date birthday) {
        super(name, birthday);
        this.type = "pet";
        this.subType = "dog";

    }
 
}
