package common.dao.system.impl;

import common.dao.system.IShipAddressDao;
import common.entity.system.ShipAddress;
import common.entity.system.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Repository
public class ShipAddressDaoImpl implements IShipAddressDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean isExist(ShipAddress shipAddress) {
        return false;
    }

    public ShipAddress getEntity(ShipAddress shipAddress) {
        return null;
    }

    public ShipAddress getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(ShipAddress.class, id);
    }

    public ShipAddress loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(ShipAddress.class, id);
    }

    public ShipAddress updateEntity(ShipAddress shipAddress) {
        sessionFactory.getCurrentSession().update(shipAddress);
        return shipAddress;
    }

    public ShipAddress deleteEntity(ShipAddress shipAddress) {
        sessionFactory.getCurrentSession().delete(shipAddress);
        return shipAddress;
    }

    public Serializable insertEntity(ShipAddress shipAddress) {
        return sessionFactory.getCurrentSession().save(shipAddress);
    }

    public List<ShipAddress> getEntities() {
        String hql = "from ShipAddress";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<ShipAddress> getEntities(int from, int size) {
        String hql = "from ShipAddress";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
