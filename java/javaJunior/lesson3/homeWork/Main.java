import java.util.ArrayList;
import java.util.List;

/*
 * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл.
Десериализуйте объект обратно в программу из файла.
Выведите все поля объекта, включая GPA, и ответьте на вопрос,
почему значение GPA не было сохранено/восстановлено.

2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */

public class Main {
    public static void main(String[] args){

        List<Student> students = new ArrayList<Student>();

        students.add(new Student("John", 19, 4.6));
        students.add(new Student("Rembo", 20, 4.5));
        students.add(new Student("Sylvester", 21, 4.4));
        students.add(new Student("Stallone", 22, 4.3));

        System.out.println(students);

        students.add(new Student("BIN", 19, 4.6));
        StudentsListApp.saveToFiles(StudentsListApp.FILE_BIN, students);
        students = StudentsListApp.loadFromFile(StudentsListApp.FILE_BIN);
        System.out.println(students);

        students.add(new Student("Json", 19, 4.6));
        StudentsListApp.saveToFiles(StudentsListApp.FILE_JSON, students);
        students = StudentsListApp.loadFromFile(StudentsListApp.FILE_JSON);
        System.out.println(students);

        students.add(new Student("XML", 19, 4.6));
        StudentsListApp.saveToFiles(StudentsListApp.FILE_XML, students);
        students = StudentsListApp.loadFromFile(StudentsListApp.FILE_XML);
        System.out.println(students);

    }
}
