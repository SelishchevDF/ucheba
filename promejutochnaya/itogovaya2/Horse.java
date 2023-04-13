import java.util.Date;
import java.util.List;

public class Horse extends SubTypeAnimal {

    public Horse(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
        this.type = "pack animal";
        this.subType = "horse";

    }

    public Horse(String name, Date birthday) {
        super(name, birthday);
        this.type = "pack animal";
        this.subType = "horse";

    }
   
}
