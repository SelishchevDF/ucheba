import java.util.Date;
import java.util.List;

public class Donkey extends SubTypeAnimal  {

    public Donkey(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
        this.type = "pack animal";
        this.subType = "donkey";

    }

    public Donkey(String name, Date birthday) {
        super(name, birthday);
        this.type = "pack animal";
        this.subType = "donkey";

    }
  
}
