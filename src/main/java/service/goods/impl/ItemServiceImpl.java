package service.goods.impl;

import common.dao.goods.IItemDao;
import common.entity.goods.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.goods.IItemService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/1.
 */
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    private IItemDao iItemDao;

    public Item getEntity(Item item) {
        return null;
    }

    @Transactional
    public Item getEntity(Serializable id) {
        return iItemDao.getEntity(id);
    }

    @Transactional
    public Item loadEntity(Serializable id) {
        return iItemDao.loadEntity(id);
    }

    @Transactional
    public Item updateEntity(Item item) {
        return iItemDao.updateEntity(item);
    }

    @Transactional
    public Item deleteEntity(Item item) {
        return iItemDao.deleteEntity(item);
    }

    @Transactional
    public Serializable insertEntity(Item item) {
        return iItemDao.insertEntity(item);
    }

    @Transactional
    public List<Item> getEntities() {
        return iItemDao.getEntities();
    }

    @Transactional
    public List<Item> getEntities(int from, int size) {
        return iItemDao.getEntities(from, size);
    }
}
