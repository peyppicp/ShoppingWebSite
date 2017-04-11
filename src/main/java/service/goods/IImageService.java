package service.goods;

import common.entity.goods.Image;
import service.BasicService;

/**
 * Created by peyppicp on 2017/4/9.
 */
public interface IImageService extends BasicService<Image> {

    Image getImageByProductItem(String product_id, String item_id);

    void saveOrUpdateEntity(Image image);
}
