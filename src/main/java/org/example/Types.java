package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

import static org.example.Types.Hibernate.factory;

public class Types {

    public static class Hibernate {

        public static final SessionFactory factory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();

        public static SessionFactory getSessionFactory() {
            return factory;
        }
    }

    public static void main(String[] args) {

        SessionFactory factory = Hibernate.getSessionFactory();

        try {
        Session session = factory.openSession();
            List<Line> lines = session
                    .createQuery("FROM Line", Line.class)
                    .getResultList();

            for (Line line : lines) {
                System.out.println("Line: " + line.getName());

                for (Category cat : line.getCat()) {
                    System.out.println("  Category: " + cat.getName());

                    for (Model model : cat.getModel()) {
                        System.out.println("    Model: " + model.getName());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    public static List<Line> getLines() {
        List<Line> lines = new ArrayList<>();
        try {
            Session session = factory.openSession();
            lines = session
                    .createQuery("FROM Line", Line.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
    public static List<Category> getCategories() {
        List<Category> cat = new ArrayList<>();
        try {
            Session session = factory.openSession();
            cat = session
                    .createQuery("FROM Category", Category.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cat;
    }

    public static List<Model> getModels() {
        List<Model> models = new ArrayList<>();
        try {
            Session session = factory.openSession();
            models = session
                    .createQuery("FROM Model", Model.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }
}

