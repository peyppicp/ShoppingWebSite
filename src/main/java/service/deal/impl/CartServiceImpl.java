package service.deal.impl;

import common.dao.deal.ICartDao;
import common.entity.deal.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.deal.ICartService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/12.
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartDao iCartDao;

    @Transactional
    public Cart getEntity(Cart cart) {
        return null;
    }

    @Transactional
    public Cart getEntity(Serializable id) {
        return iCartDao.getEntity(id);
    }

    @Transactional
    public Cart loadEntity(Serializable id) {
        return iCartDao.loadEntity(id);
    }

    @Transactional
    public Cart updateEntity(Cart cart) {
        return iCartDao.updateEntity(cart);
    }

    @Transactional
    public Cart deleteEntity(Cart cart) {
        return iCartDao.deleteEntity(cart);
    }

    @Transactional
    public Serializable insertEntity(Cart cart) {
        return iCartDao.insertEntity(cart);
    }

    @Transactional
    public List<Cart> getEntities() {
        return iCartDao.getEntities();
    }

    @Transactional
    public List<Cart> getEntities(int from, int size) {
        return iCartDao.getEntities(from, size);
    }
}
