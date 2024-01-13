package t2;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ServerStorage implements ServerStorageInterface {
    final static private String fileName = "log.txt";

    Path path;
    File file = new File(fileName);

    public ServerStorage(){
        path = Paths.get(fileName);

    }

    //@Override
    public void writeToStorage(String msg) {
        try{
            Files.write(path,
                        msg.getBytes(),
                        StandardOpenOption.APPEND,
                        StandardOpenOption.CREATE
                    );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //@Override
    public String getLog() {
        String log = "";
        try {
            List<String> lines = Files.readAllLines(path);
            for (String string : lines) {
                log = string + "\n";  
            }
        }
        catch (Exception e) {
                e.printStackTrace();
        }
        return log + "\n";    
    }

    public void stopServer() {
        file.delete();
    }


    
}
