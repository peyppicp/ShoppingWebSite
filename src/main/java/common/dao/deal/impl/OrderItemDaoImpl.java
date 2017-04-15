package common.dao.deal.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import common.dao.deal.IOrderItemDao;
import common.entity.deal.OrderItem;
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
public class OrderItemDaoImpl implements IOrderItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean isExist(OrderItem orderItem) {
        return false;
    }

    public OrderItem getEntity(OrderItem orderItem) {
        return null;
    }

    public OrderItem getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(OrderItem.class, id);
    }

    public OrderItem loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(OrderItem.class, id);
    }

    public OrderItem updateEntity(OrderItem orderItem) {
        sessionFactory.getCurrentSession().update(orderItem);
        return orderItem;
    }

    public OrderItem deleteEntity(OrderItem orderItem) {
        sessionFactory.getCurrentSession().delete(orderItem);
        return orderItem;
    }

    public Serializable insertEntity(OrderItem orderItem) {
        return sessionFactory.getCurrentSession().save(orderItem);
    }

    public List<OrderItem> getEntities() {
        String hql = "from OrderItem";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<OrderItem> getEntities(int from, int size) {
        String hql = "from OrderItem";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
