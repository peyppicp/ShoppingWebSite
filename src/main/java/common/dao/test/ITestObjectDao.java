package common.dao.test;

import common.entity.TestObject;

/**
 * Created by peyppicp on 2017/3/8.
 */
public interface ITestObjectDao {

    int saveTestObject(TestObject testObject);

    TestObject get(long id);
}
