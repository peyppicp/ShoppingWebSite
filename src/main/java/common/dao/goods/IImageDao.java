package common.dao.goods;

import common.dao.BasicDao;
import common.entity.goods.Image;

/**
 * Created by peyppicp on 2017/4/9.
 */
public interface IImageDao extends BasicDao<Image> {

    Image getImageByProductItem(String product_id, String item_id);

    void saveOrUpdateEntity(Image image);
}
