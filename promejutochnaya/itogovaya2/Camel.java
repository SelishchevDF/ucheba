import java.util.Date;
import java.util.List;

public class Camel extends SubTypeAnimal {

    public Camel(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
        this.type = "pack animal";
        this.subType = "camel";

    }

    public Camel(String name, Date birthday) {
        super(name, birthday);
        this.type = "pack animal";
        this.subType = "camel";

    }
  
}
