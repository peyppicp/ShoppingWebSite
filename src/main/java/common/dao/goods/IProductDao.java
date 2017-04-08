package common.dao.goods;

import common.dao.BasicDao;
import common.entity.goods.Product;

/**
 * Created by peyppicp on 2017/4/1.
 */
public interface IProductDao extends BasicDao<Product> {

    Product getProductByNameAndUserId(String userId, String name);
}
