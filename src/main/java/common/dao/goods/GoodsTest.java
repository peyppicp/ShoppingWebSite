package common.dao.goods;

import common.entity.goods.Category;
import common.entity.goods.Item;
import common.entity.goods.Product;
import common.entity.goods.ProductCatetgory;
import common.entity.system.User;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import utils.PrimaryKeyGenerator;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/3/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring.xml"})
public class GoodsTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    @Transactional
    @Rollback(value = false)
    public void test() {
        User user = sessionFactory.getCurrentSession().get(User.class, "f571bdb3-d9d4-4055-a305-8d30cbd53881");
        Product product = new Product();
        product.setProduct_id(PrimaryKeyGenerator.uuid());
        product.setProduct_name("1111");
        product.setProduct_number(new BigDecimal(4));
        product.setUser(user);
        Category category = new Category();
        category.setCategory_id(PrimaryKeyGenerator.uuid());
        category.setCategory_name("2222");
        category.setParent_id("1");
        ProductCatetgory productCatetgory = new ProductCatetgory();
        productCatetgory.setCategory(category);
        productCatetgory.setProduct(product);
        sessionFactory.getCurrentSession().save(product);
        sessionFactory.getCurrentSession().save(category);
        sessionFactory.getCurrentSession().save(productCatetgory);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void test1() {
        Item item = new Item();
        item.setItem_id(PrimaryKeyGenerator.uuid());
        item.setPrice(new BigDecimal(10));
        item.setInventory(100);
        item.setSize("11243152");
        item.setType("nihao");
        sessionFactory.getCurrentSession().save(item);
    }
}
