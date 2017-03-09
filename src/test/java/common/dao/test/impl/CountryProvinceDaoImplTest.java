package common.dao.test.impl;

import common.dao.test.ICountryProviceTestDao;
import common.entity.system.City;
import common.entity.system.Country;
import common.entity.system.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring-dao.xml"})
public class CountryProvinceDaoImplTest {

    @Autowired
    private ICountryProviceTestDao iCountryProviceTestDao;

    @Test
    @Transactional
    @Rollback(value = false)
    public void test1() throws Exception {
        Country country = new Country();
        country.setCountry_num(new BigDecimal(1));
        country.setCountry_name("China");
        Province province = new Province();
        province.setCountry(country);
        province.setProv_name("beijing");
        province.setProv_num(new BigDecimal(2));
        City city = new City();
        city.setProvince(province);
        city.setCity_num(new BigDecimal(3));
        city.setCity_name("shanghai");
        iCountryProviceTestDao.test(country, province, city);
    }

    @Test
    @Transactional
    public void test2() {
        iCountryProviceTestDao.test1();
    }

}