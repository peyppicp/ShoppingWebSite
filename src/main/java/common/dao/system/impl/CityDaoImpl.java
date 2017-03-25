package common.dao.system.impl;

import common.dao.system.ICityDao;
import common.entity.system.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/9.
 */
@Repository
public class CityDaoImpl implements ICityDao {

    @Autowired
    private SessionFactory sessionFactory;

    //    TODO
    public boolean isExist(City city) {
        return false;
    }

    public City getEntity(City city) {
        return null;
    }

    public City getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(City.class, id);
    }

    public City loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(City.class, id);
    }

    public City updateEntity(City city) {
        sessionFactory.getCurrentSession().update(city);
        return city;
    }

    public City deleteEntity(City city) {
        sessionFactory.getCurrentSession().delete(city);
        return city;
    }

    public Serializable insertEntity(City city) {
        return sessionFactory.getCurrentSession().save(city);
    }

    public List<City> getEntities() {
        String hql = "from City";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<City> getEntities(int from, int size) {
        String hql = "from City";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
