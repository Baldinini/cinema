package mate.academy.dao.impl;

import java.util.List;
import mate.academy.dao.OrdersDao;
import mate.academy.exception.DataProcessingException;
import mate.academy.lib.Dao;
import mate.academy.model.Orders;
import mate.academy.model.User;
import mate.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class OrdersDaoImpl implements OrdersDao {
    @Override
    public Orders add(Orders orders) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(orders);
            transaction.commit();
            return orders;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert order entity"
                    + orders, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Orders> getOrdersHistory(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Orders> getAllOrdersQuery = session.createQuery("from Orders o "
                    + "left join fetch o.tickets "
                    + "where o.user = :user", Orders.class)
                    .setParameter("user", user);
            return getAllOrdersQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all orders by user: " + user, e);
        }
    }
}
