package common.dao.system.impl;

import common.dao.system.ICountryDao;
import common.entity.system.Country;
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
public class CountryDaoImpl implements ICountryDao {

    @Autowired
    private SessionFactory sessionFactory;

    //    TODO
    public boolean isExist(Country country) {
        return false;
    }

    public Country getEntity(Country country) {
        return null;
    }

    public Country getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(Country.class, id);
    }

    public Country loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(Country.class, id);
    }

    public Country updateEntity(Country country) {
        sessionFactory.getCurrentSession().update(country);
        return country;
    }

    public Country deleteEntity(Country country) {
        sessionFactory.getCurrentSession().delete(country);
        return country;
    }

    public Serializable insertEntity(Country country) {
        return sessionFactory.getCurrentSession().save(country);
    }

    public List<Country> getEntities() {
        String hql = "from Country";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Deprecated
    public List<Country> getEntities(int from, int size) {
        return null;
    }
}
