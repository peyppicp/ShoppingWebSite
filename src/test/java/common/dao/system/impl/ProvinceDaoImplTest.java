package common.dao.system.impl;

import common.dao.system.IProvinceDao;
import common.entity.system.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by peyppicp on 2017/3/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring-dao.xml"})
public class ProvinceDaoImplTest {

    @Autowired
    private IProvinceDao iProvinceDao;

    @Test
    @Transactional
    public void getEntity() throws Exception {
        Province entity = iProvinceDao.getEntity(new BigDecimal(2));
        System.out.println();
    }

    @Test
    public void loadEntity() throws Exception {

    }

    @Test
    public void updateEntity() throws Exception {

    }

    @Test
    public void deleteEntity() throws Exception {

    }

    @Test
    public void insertEntity() throws Exception {

    }

    @Test
    @Transactional
    public void getEntities() throws Exception {
        List<Province> entities = iProvinceDao.getEntities();
        System.out.println();
    }

    @Test
    public void getEntities1() throws Exception {

    }

}