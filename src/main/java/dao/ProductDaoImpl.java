package dao;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtils;
import java.util.List;


@SuppressWarnings("JpaQlInspection")
public class ProductDaoImpl implements ProductDao {
    final SessionFactory factory = HibernateUtils.getSessionFactory();

    @Override
    public void saveProduct(Product products) {
        Session s = factory.openSession();
        Transaction t = s.beginTransaction();
        s.save(products);
        t.commit();
        s.close();
    }

//    @Override
//    public Product getProductById(int id) {
//        return null;
//    }

    @Override
    public List<Product> findAll() {
        final Session session = factory.openSession();
        List products = session.createQuery("FROM Product").getResultList();
        session.close();
        return products;
    }
}








/*    SessionFactory sessionFactory = getSessionFactory();

    @Override
    public Product getAllProducts(long id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        Product retrieved = s.load(Product.class, id);
        t.commit();
        s.close();
        return retrieved;
    }

    @Override
    public void save(Product products) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(products);
        t.commit();
        s.close();
    }
*/


