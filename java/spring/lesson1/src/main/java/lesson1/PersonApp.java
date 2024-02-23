package lesson1;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PersonApp {

    public static final String FILE_JSON = "tasks.json";

    private static final Gson gson = new Gson();




    public static void saveToFiles(String fileName, List<Person> students){

        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(gson.toJson(students, students.getClass()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Person> loadFromFile(String fileName){
        List<Person> students = new ArrayList<>();

        File f = new File(fileName);
        if (f.exists()) {
            try {

                students = gson.fromJson(Files.readString(Paths.get(fileName)), students.getClass());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return students;
    }

}
