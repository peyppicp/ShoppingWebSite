package common.dao.goods.impl;

import common.dao.goods.IItemDao;
import common.entity.goods.Item;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/1.
 */
@Repository
public class ItemDaoImpl implements IItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean isExist(Item item) {
        return false;
    }

    public Item getEntity(Item item) {
        return null;
    }

    public Item getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(Item.class, id);
    }

    public Item loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(Item.class, id);
    }

    public Item updateEntity(Item item) {
        sessionFactory.getCurrentSession().update(item);
        return item;
    }

    public Item deleteEntity(Item item) {
        sessionFactory.getCurrentSession().delete(item);
        return item;
    }

    public Serializable insertEntity(Item item) {
        return sessionFactory.getCurrentSession().save(item);
    }

    public List<Item> getEntities() {
        String hql = "from Item";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<Item> getEntities(int from, int size) {
        String hql = "from Item";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
