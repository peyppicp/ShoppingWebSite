package common.dao.system.impl;

import common.dao.system.IProvinceDao;
import common.entity.system.Province;
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
public class ProvinceDaoImpl implements IProvinceDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Province getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(Province.class, id);
    }

    public Province loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(Province.class, id);
    }

    public Province updateEntity(Province province) {
        sessionFactory.getCurrentSession().update(province);
        return province;
    }

    public Province deleteEntity(Province province) {
        sessionFactory.getCurrentSession().delete(province);
        return province;
    }

    public Serializable insertEntity(Province province) {
        return sessionFactory.getCurrentSession().save(province);
    }

    public List<Province> getEntities() {
        String hql = "from Province";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<Province> getEntities(int from, int size) {
        String hql = "from Province";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
