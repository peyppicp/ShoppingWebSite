package service.goods;

import common.entity.goods.Product;
import service.BasicService;

/**
 * Created by peyppicp on 2017/4/1.
 */
public interface IProductService extends BasicService<Product> {

    Product getProductByNameAndUserId(String userId, String name);
}
