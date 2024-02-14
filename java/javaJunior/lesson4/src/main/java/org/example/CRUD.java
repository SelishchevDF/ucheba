package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.Course;
import java.util.List;

public class CRUD {

    // Создание фабрики сессий
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

    // Создание сессии
    public void create(List<Course> coursesList){

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            coursesList.forEach(course -> {
                session.save(course);
                System.out.println("Object save successfully:" + course);
            });

            session.getTransaction().commit();
        }
    }

    public void readAll(){
        List<Course> course;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            course = session.createCriteria(Course.class).list();

            session.getTransaction().commit();
        }

        course.forEach(c -> System.out.println("Object read successfully:" + c));

    }

    public void readById(int id){

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Course course = (Course) session.get(Course.class, id);

            System.out.println("Object read BY ID successfully:" + course);

            session.getTransaction().commit();
        }

    }

    public void updateById(int id){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Course course = (Course) session.get(Course.class, id);
            course.updateName();
            session.update(course);
            System.out.println("Object update BY ID successfully:" + course);

            session.getTransaction().commit();
        }
    }

    public void deleteById(int id){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Course course = session.get(Course.class, id);
            session.delete(course);
            System.out.println("Object delete BY ID successfully:" + course);

            session.getTransaction().commit();
        }
    }

    public void deleteAll(){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            List<Course> course = session.createCriteria(Course.class).list();
            course.forEach(session::delete);
            System.out.println("Objects deleted");

            session.getTransaction().commit();
        }
    }

    public  void factoryClose(){
        sessionFactory.close();
    }

}
