package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

import static org.example.DBcon.Hibernate.factory;

public class DBcon {

    public static class Hibernate {

        public static final SessionFactory factory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();

        public static SessionFactory getSessionFactory() {
            return factory;
        }
    }

static Session session = factory.openSession();

    public static List<Line> getLines() {
        List<Line> lines = new ArrayList<>();
        try {
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
            models = session
                    .createQuery("FROM Model", Model.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }
}

