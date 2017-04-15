package service.deal.impl;

import common.dao.deal.IOrderDao;
import common.entity.deal.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.deal.IOrderService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/15.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao iOrderDao;

    public Order getEntity(Order order) {
        return null;
    }

    @Transactional
    public Order getEntity(Serializable id) {
        return iOrderDao.getEntity(id);
    }

    @Transactional
    public Order loadEntity(Serializable id) {
        return iOrderDao.loadEntity(id);
    }

    @Transactional
    public Order updateEntity(Order order) {
        return iOrderDao.updateEntity(order);
    }

    @Transactional
    public Order deleteEntity(Order order) {
        return iOrderDao.deleteEntity(order);
    }

    @Transactional
    public Serializable insertEntity(Order order) {
        return iOrderDao.insertEntity(order);
    }

    @Transactional
    public List<Order> getEntities() {
        return iOrderDao.getEntities();
    }

    @Transactional
    public List<Order> getEntities(int from, int size) {
        return iOrderDao.getEntities(from, size);
    }
}
