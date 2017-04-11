package service.goods.impl;

import common.dao.goods.IImageDao;
import common.entity.goods.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.goods.IImageService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/9.
 */
@Service
public class ImageService implements IImageService {

    @Autowired
    private IImageDao iImageDao;

    @Transactional
    public Image getImageByProductItem(String product_id, String item_id) {
        return iImageDao.getImageByProductItem(product_id, item_id);
    }

    public void saveOrUpdateEntity(Image image) {
        iImageDao.saveOrUpdateEntity(image);
    }

    @Transactional
    public Image getEntity(Image image) {
        return null;
    }

    @Transactional
    public Image getEntity(Serializable id) {
        return iImageDao.getEntity(id);
    }

    @Transactional
    public Image loadEntity(Serializable id) {
        return iImageDao.loadEntity(id);
    }

    @Transactional
    public Image updateEntity(Image image) {
        return iImageDao.updateEntity(image);
    }

    @Transactional
    public Image deleteEntity(Image image) {
        return iImageDao.deleteEntity(image);
    }

    @Transactional
    public Serializable insertEntity(Image image) {
        return iImageDao.insertEntity(image);
    }

    @Transactional
    public List<Image> getEntities() {
        return iImageDao.getEntities();
    }

    @Transactional
    public List<Image> getEntities(int from, int size) {
        return iImageDao.getEntities(from, size);
    }
}
