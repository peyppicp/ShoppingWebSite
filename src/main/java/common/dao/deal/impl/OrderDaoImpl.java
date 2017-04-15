package common.dao.deal.impl;

import common.dao.deal.IOrderDao;
import common.entity.deal.Order;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/15.
 */
@Repository
public class OrderDaoImpl implements IOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean isExist(Order order) {
        return false;
    }

    public Order getEntity(Order order) {
        return null;
    }

    public Order getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }

    public Order loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(Order.class, id);
    }

    public Order updateEntity(Order order) {
        sessionFactory.getCurrentSession().update(order);
        return order;
    }

    public Order deleteEntity(Order order) {
        sessionFactory.getCurrentSession().delete(order);
        return order;
    }

    public Serializable insertEntity(Order order) {
        return sessionFactory.getCurrentSession().save(order);
    }

    public List<Order> getEntities() {
        String hql = "from Order";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<Order> getEntities(int from, int size) {
        String hql = "from Order";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
