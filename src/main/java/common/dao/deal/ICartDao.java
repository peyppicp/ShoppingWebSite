package common.dao.deal;

import common.dao.BasicDao;
import common.entity.deal.Cart;
import common.entity.goods.Item;
import common.entity.system.User;

/**
 * Created by peyppicp on 2017/4/12.
 */
public interface ICartDao extends BasicDao<Cart> {

    int getNumber(Item item, User seller);
}
