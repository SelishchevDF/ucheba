import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Program {
    private static final String BKP_SRC_FOLDER = ".";
    private static final String BKP_DST_FOLDER = "backup";

    public static void main(String[] args) {
        try {
            createBackup(BKP_SRC_FOLDER, BKP_DST_FOLDER);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createBackup(String srcFolder, String dstFolder) throws IOException {

        File backupDir = new File(dstFolder);
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        File sourceDir = new File(srcFolder);
        File[] filesToBackup = sourceDir.listFiles();

        for (File file : filesToBackup) {
            if (file.isFile()) {
                Files.copy(file.toPath(), new File(backupDir.getPath() + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
