import java.io.FileWriter;
import java.io.IOException;


public class SaveToTxt {
    
    public static void saveAs(String[] str){
        String path = CONST.PATHTOSAVE + str[2] + ".txt";
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(str[1]+"\n");
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
