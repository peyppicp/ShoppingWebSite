package common.dao.test.impl;

import common.dao.test.ICountryDao;
import common.entity.system.Country;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by peyppicp on 2017/3/8.
 */
@Repository
public class CountryDaoImpl implements ICountryDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int save(Country country) {
        Serializable save = sessionFactory.getCurrentSession().save(country);
        return ((Integer) save).intValue();
    }

    public Country get(long id) {
        return null;
    }
}
