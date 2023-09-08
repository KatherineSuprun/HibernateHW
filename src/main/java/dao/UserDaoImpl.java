package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static util.HibernateUtils.getSessionFactory;

public class UserDaoImpl implements UserDao {

    SessionFactory sessionFactory = getSessionFactory();

    @Override
    public void saveUser(User user) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(user);
        t.commit();
        s.close();
    }

    @Override
    public User getUserById(long id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        User retrieved = s.load(User.class, id);
        t.commit();
        s.close();
        return retrieved;
    }
}