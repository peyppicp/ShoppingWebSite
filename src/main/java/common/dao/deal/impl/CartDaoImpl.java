package common.dao.deal.impl;

import common.dao.deal.ICartDao;
import common.entity.deal.Cart;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/12.
 */
@Repository
public class CartDaoImpl implements ICartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean isExist(Cart cart) {
        return false;
    }

    public Cart getEntity(Cart cart) {
        return null;
    }

    public Cart getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(Cart.class, id);
    }

    public Cart loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(Cart.class, id);
    }

    public Cart updateEntity(Cart cart) {
        sessionFactory.getCurrentSession().update(cart);
        return cart;
    }

    public Cart deleteEntity(Cart cart) {
        sessionFactory.getCurrentSession().delete(cart);
        return cart;
    }

    public Serializable insertEntity(Cart cart) {
        return sessionFactory.getCurrentSession().save(cart);
    }

    public List<Cart> getEntities() {
        String hql = "from Cart";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<Cart> getEntities(int from, int size) {
        String hql = "from Cart";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
