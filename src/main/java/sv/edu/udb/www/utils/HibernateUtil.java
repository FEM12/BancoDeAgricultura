package sv.edu.udb.www.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {

        try {

            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = cfg.buildSessionFactory();

        }
        catch (Throwable th) {

            System.err.println("\n\nInitial SessionFactory creation failed: \n\n" + th);
            throw new ExceptionInInitializerError(th);

        }

    }

    public static SessionFactory getSessionFactory() { return sessionFactory; }

}

