import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Animal{

    private String name;
    private Date birthday;
    private List <String> commands = new ArrayList<String>();

    public Animal(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    
    public Animal(String name, Date birthday, List<String> commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCommands() {
        String result = "";
        if (this.commands.size() == 0) result = "Ничего не умеет";
        else for (String string : commands) {
            result = result + string + " ";
        }
        return result;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    public String getBirthdayFormatted(){
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
        String str = formater.format(birthday);
        return str;
    }
}