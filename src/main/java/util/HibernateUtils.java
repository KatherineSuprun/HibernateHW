package util;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
                        .addAnnotatedClass(Product.class)
                        .addAnnotatedClass(User.class)
                        .addAnnotatedClass(Order.class)
                        .addAnnotatedClass(Customer.class)
                        .addAnnotatedClass(OrderDetails.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }
}