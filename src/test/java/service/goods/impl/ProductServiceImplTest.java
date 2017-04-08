package service.goods.impl;

import common.entity.goods.Product;
import common.entity.system.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.goods.IProductService;
import service.system.IUserService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by peyppicp on 2017/4/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring.xml"})
public class ProductServiceImplTest {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IUserService iUserService;

    @Test
    @Rollback(value = false)
    @Transactional
    public void deleteEntity() throws Exception {

        List<Product> entities = iProductService.getEntities();
        Product product = entities.get(0);
//        iProductService.deleteEntity(product);
        System.out.println();
    }

    @Test
    public void test() {
        List<Product> entities = iProductService.getEntities();
    }

}