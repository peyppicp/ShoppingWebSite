package common.dao.system.impl;

import common.dao.system.IUserDao;
import common.entity.system.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import utils.PrimaryKeyGenerator;

import java.util.List;

/**
 * Created by peyppicp on 2017/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring.xml"})
public class UserDaoImplTest {

    @Autowired
    private IUserDao iUserDao;

    @Test
    public void getEntity() throws Exception {

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
    @Transactional
    public void insertEntity() throws Exception {
        User user = new User();
        user.setUser_id(PrimaryKeyGenerator.uuid());
        iUserDao.insertEntity(user);
    }

    @Test
    @Transactional
    public void getEntities() throws Exception {
        List<User> entities = iUserDao.getEntities();
        System.out.println();
    }

    @Test
    public void getEntities1() throws Exception {

    }

}