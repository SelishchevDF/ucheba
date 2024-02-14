package org.example;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Courses")
public class Course {

    private static final String[] names = new String[] { "Русский", "математика", "обществознание", "литература",
                                                        "физика", "химия"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Course() {}

    public Course(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Course createCourse(){

        return new Course(names[random.nextInt(names.length)]);

    }

    public void updateName(){
        name = names[random.nextInt(names.length)];
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
