package service.system.impl;

import common.entity.system.User;
import service.system.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.PrimaryKeyGenerator;

/**
 * Created by peyppicp on 2017/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring.xml"})
public class UserServiceImplTest {

    @Autowired
    private IUserService iUserService;

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
    public void insertEntity() throws Exception {
        User user = new User();
        user.setUser_id(PrimaryKeyGenerator.uuid());
        iUserService.insertEntity(user);
    }

    @Test
    public void getEntities() throws Exception {

    }

    @Test
    public void getEntities1() throws Exception {

    }

}