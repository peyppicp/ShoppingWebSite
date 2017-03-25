package common.dao.system.impl;

import com.google.common.base.Stopwatch;
import common.dao.system.IUserDao;
import common.entity.goods.Product;
import common.entity.system.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import utils.PrimaryKeyGenerator;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by peyppicp on 2017/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring.xml"})
public class UserDaoImplTest {

    @Autowired
    private IUserDao iUserDao;

    @Test
    @Transactional
    public void getEntity() throws Exception {
        User entity = iUserDao.getEntity("f571bdb3-d9d4-4055-a305-8d30cbd53881");
        List<Product> productList = entity.getProductList();
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
    @Transactional
    @Rollback(value = false)
    public void insertEntity() throws Exception {
        User user = new User();
        user.setUser_id(PrimaryKeyGenerator.uuid());
        user.setUser_account("peyppicp");
        user.setUser_password("1234");
        user.setUser_credit(0);
        user.setUser_key("");
        user.setUser_points(0);
        user.setUser_seller_status(true);
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

    @Test
    @Transactional
    public void isExist() throws Exception {
        User user = new User();
        user.setUser_account("peyppicp");
        Stopwatch started = Stopwatch.createStarted();
        for (int i = 0; i < 1000; i++) {
            boolean exist = iUserDao.isExist(user);
            System.out.println(exist);
        }
        System.out.println(started.stop().elapsed(TimeUnit.MILLISECONDS));
    }

}