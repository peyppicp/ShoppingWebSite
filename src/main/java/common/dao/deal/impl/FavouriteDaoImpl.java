package common.dao.deal.impl;

import common.dao.deal.IFavouriteDao;
import common.entity.deal.Favorite;
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
public class FavouriteDaoImpl implements IFavouriteDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean isExist(Favorite favorite) {
        return false;
    }

    public Favorite getEntity(Favorite favorite) {
        return null;
    }

    public Favorite getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(Favorite.class, id);
    }

    public Favorite loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(Favorite.class, id);
    }

    public Favorite updateEntity(Favorite favorite) {
        sessionFactory.getCurrentSession().update(favorite);
        return favorite;
    }

    public Favorite deleteEntity(Favorite favorite) {
        sessionFactory.getCurrentSession().delete(favorite);
        return favorite;
    }

    public Serializable insertEntity(Favorite favorite) {
        return sessionFactory.getCurrentSession().save(favorite);
    }

    public List<Favorite> getEntities() {
        String hql = "from Favourite";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<Favorite> getEntities(int from, int size) {
        String hql = "from Favourite";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
