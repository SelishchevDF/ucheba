package lesson1;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> l = new ArrayList<>();


        l.add(new Person("f1","l1", 1));
        l.add(new Person("f2","l2", 2));
        l.add(new Person("f3","l3", 3));
        l.add(new Person("f4","l4", 4));

        PersonApp.saveToFiles(PersonApp.FILE_JSON, l);

        System.out.println(PersonApp.loadFromFile(PersonApp.FILE_JSON));





    }
}