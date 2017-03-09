package common.dao.test.impl;

import common.dao.test.ITestObjectDao;
import common.entity.TestObject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by peyppicp on 2017/3/8.
 */
@Repository
public class TestObjectDaoImpl implements ITestObjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int saveTestObject(TestObject testObject) {
        Serializable save = sessionFactory.getCurrentSession().save(testObject);
        System.out.println(save);
        return ((Long) save).intValue();
    }

    public TestObject get(long id) {
        return null;
    }
}
