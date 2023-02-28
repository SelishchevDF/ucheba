import java.io.FileWriter;
import java.io.IOException;


public class SaveToTxt {

    private static String path = "выданные игрушки.txt";
    
    public static void saveAs(String str){
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
