package common.dao.system.impl;

import common.dao.system.ICountryDao;
import common.entity.system.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring.xml"})
public class CountryDaoImplTest {

    @Autowired
    private ICountryDao iCountryDao;

    @Test
    @Transactional
    public void getEntity() throws Exception {
        Country entity = iCountryDao.getEntity(new BigDecimal(1));
        System.out.println();
    }

    @Test
    public void loadEntity() throws Exception {

    }

    @Test
    @Transactional
    public void getEntities() throws Exception {
        List<Country> entities = iCountryDao.getEntities();
        System.out.println();
    }
}