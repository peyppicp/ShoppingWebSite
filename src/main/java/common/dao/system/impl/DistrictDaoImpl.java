package common.dao.system.impl;

import common.dao.system.IDistrictDao;
import common.entity.system.District;
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
public class DistrictDaoImpl implements IDistrictDao {

    @Autowired
    private SessionFactory sessionFactory;

    //    TODO
    public boolean isExist(District district) {
        return false;
    }

    public District getEntity(District district) {
        return null;
    }

    public District getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(District.class, id);
    }

    public District loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(District.class, id);
    }

    public District updateEntity(District district) {
        sessionFactory.getCurrentSession().update(district);
        return district;
    }

    public District deleteEntity(District district) {
        sessionFactory.getCurrentSession().delete(district);
        return district;
    }

    public Serializable insertEntity(District district) {
        return sessionFactory.getCurrentSession().save(district);
    }

    public List<District> getEntities() {
        String hql = "from District";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<District> getEntities(int from, int size) {
        String hql = "from District";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
