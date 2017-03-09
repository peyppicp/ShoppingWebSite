package common.dao.test.impl;

import common.dao.test.ICountryDao;
import common.entity.system.Country;
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
public class CountryDaoImplTest {

    @Autowired
    private ICountryDao iCountryDao;

    @Test
    @Transactional
    @Rollback(value = false)
    public void save() throws Exception {
        Country country = new Country();
        country.setCountry_name("zhongguo");
        country.setCountry_num(new BigDecimal(1111));
        int save = iCountryDao.save(country);
        System.out.println(save);
    }

}