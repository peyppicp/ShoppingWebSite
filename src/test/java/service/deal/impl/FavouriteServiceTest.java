package service.deal.impl;

import common.entity.deal.Favorite;
import common.entity.goods.Item;
import common.entity.system.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import service.deal.IFavouriteService;
import service.goods.IItemService;
import service.system.IUserService;

import static org.junit.Assert.*;

/**
 * Created by peyppicp on 2017/4/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring.xml"})
public class FavouriteServiceTest {

    @Autowired
    private IFavouriteService iFavouriteService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IItemService iItemService;

    @Test
//    @Rollback(value = false)
    public void insertEntity() throws Exception {
        String user_id = "aaff399d-f8ef-4311-90bd-769317ac9354";
        String item_id = "0d68cb3b-de57-4802-81b6-1a7f7832c9fc";
        Favorite favourite = new Favorite();
        Item item = iItemService.getEntity(item_id);
        User user = iUserService.getEntity(user_id);
        favourite.setUser(user);
        favourite.setItem(item);
        iFavouriteService.insertEntity(favourite);
    }

}