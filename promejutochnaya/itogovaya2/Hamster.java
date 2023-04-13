import java.util.Date;
import java.util.List;

public class Hamster extends SubTypeAnimal {

    public Hamster(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
        this.type = "pet";
        this.subType = "hamster";

    }

    public Hamster(String name, Date birthday) {
        super(name, birthday);
        this.type = "pet";
        this.subType = "hamster";

    }

}

