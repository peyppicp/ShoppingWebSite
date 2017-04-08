package common.dao.goods.impl;

import common.dao.goods.IProductDao;
import common.dao.system.IUserDao;
import common.entity.goods.Product;
import common.entity.system.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import utils.PrimaryKeyGenerator;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by peyppicp on 2017/4/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring.xml"})
public class ProductDaoImplTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private IProductDao iProductDao;

    @Autowired
    private IUserDao iUserDao;

    @Test
    public void isExist() throws Exception {

    }

    @Test
    public void getEntity() throws Exception {

    }

    @Test
    public void getEntity1() throws Exception {

    }

    @Test
    public void loadEntity() throws Exception {

    }

    @Test
    public void updateEntity() throws Exception {

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void deleteEntity() throws Exception {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, "f571bdb3-d9d4-4055-a305-8d30cbd53881");
        Product product = currentSession.get(Product.class, "20a08e20-ef93-49dd-ae50-a6bb317c3a02");
        product.setUser(user);
        currentSession.delete(product);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void insertEntity() throws Exception {
        Product product = new Product();
        User user = new User();
        user.setUser_account("peyppicp");
        User entity = iUserDao.getEntity(user);
        product.setProduct_id(PrimaryKeyGenerator.uuid());
        product.setUser(entity);
        iProductDao.insertEntity(product);
    }

    @Test
    public void getEntities() throws Exception {

    }

    @Test
    public void getEntities1() throws Exception {

    }

    @Test
    @Transactional
    public void test1() {
        String userId = "f571bdb3-d9d4-4055-a305-8d30cbd53881";
        String productName = "feiao x5 ";
        Product productByNameAndUserId = iProductDao.getProductByNameAndUserId(userId, productName);
        System.out.println();
    }

}