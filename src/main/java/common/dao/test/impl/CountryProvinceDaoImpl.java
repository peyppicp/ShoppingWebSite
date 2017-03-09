package common.dao.test.impl;

import common.dao.test.ICountryProviceTestDao;
import common.entity.system.City;
import common.entity.system.Country;
import common.entity.system.Province;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/3/8.
 */
@Repository
public class CountryProvinceDaoImpl implements ICountryProviceTestDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int test(Country country, Province province,City city) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(country);
        currentSession.save(province);
        currentSession.save(city);
        return 0;
    }

    public void test1() {
        Session currentSession = sessionFactory.getCurrentSession();
        Country country = currentSession.get(Country.class, new BigDecimal(1));
//        Province province = currentSession.get(Province.class, new BigDecimal(2));
//        City city = currentSession.get(City.class, new BigDecimal(3));
        System.out.println();
    }
}
