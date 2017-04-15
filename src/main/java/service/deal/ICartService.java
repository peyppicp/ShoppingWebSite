package service.deal;

import common.entity.deal.Cart;
import common.entity.goods.Item;
import common.entity.system.User;
import service.BasicService;

/**
 * Created by peyppicp on 2017/4/12.
 */
public interface ICartService extends BasicService<Cart> {

    int getNumber(Item item, User seller);
}
