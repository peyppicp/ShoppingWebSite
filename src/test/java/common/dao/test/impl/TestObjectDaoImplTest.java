package common.dao.test.impl;

import common.dao.test.ITestObjectDao;
import common.entity.TestObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by peyppicp on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring-dao.xml"})
public class TestObjectDaoImplTest {

    @Autowired
    private ITestObjectDao iTestObjectDao;

    @Test
    @Transactional
    @Rollback(value = false)
    public void saveTestObject() throws Exception {
        TestObject testObject = new TestObject();
        testObject.setId(1111L);
        testObject.setDate(new Date());
        iTestObjectDao.saveTestObject(testObject);
    }

}