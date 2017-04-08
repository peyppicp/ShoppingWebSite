package service.goods.impl;

import common.dao.goods.IProductDao;
import common.entity.goods.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.goods.IProductService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/1.
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    public Product getEntity(Product product) {
        return null;
    }

    @Transactional
    public Product getEntity(Serializable id) {
        return iProductDao.getEntity(id);
    }

    @Transactional
    public Product loadEntity(Serializable id) {
        return iProductDao.loadEntity(id);
    }

    @Transactional
    public Product updateEntity(Product product) {
        return iProductDao.updateEntity(product);
    }

    @Transactional
    public Product deleteEntity(Product product) {
        return iProductDao.deleteEntity(product);
    }

    @Transactional
    public Serializable insertEntity(Product product) {
        return iProductDao.insertEntity(product);
    }

    @Transactional
    public List<Product> getEntities() {
        return iProductDao.getEntities();
    }

    @Transactional
    public List<Product> getEntities(int from, int size) {
        return iProductDao.getEntities(from, size);
    }

    public Product getProductByNameAndUserId(String userId, String productName) {
        return iProductDao.getProductByNameAndUserId(userId, productName);
    }
}
