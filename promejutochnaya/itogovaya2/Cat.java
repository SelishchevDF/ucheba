import java.util.Date;
import java.util.List;

public class Cat extends SubTypeAnimal {

    public Cat(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
        this.type = "pet";
        this.subType = "cat";
    }
  
    public Cat(String name, Date birthday) {
        super(name, birthday);
        this.type = "pet";
        this.subType = "cat";
    }
}
