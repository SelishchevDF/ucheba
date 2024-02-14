package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CRUD crud = new CRUD();

        List<Course> l = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            l.add(Course.createCourse());
        }

        //crud.create();
        //crud.readAll();
        //crud.readById(32);
        //crud.updateById(32);
        //crud.deleteById(32);
        crud.deleteAll();

        crud.factoryClose();

    }
}