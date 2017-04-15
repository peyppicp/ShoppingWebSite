package service.deal.impl;

import common.dao.deal.IOrderItemDao;
import common.entity.deal.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.deal.IOrderItemService;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/15.
 */
@Service
public class OrderItemServiceImpl implements IOrderItemService {

    @Autowired
    private IOrderItemDao iOrderItemDao;

    public OrderItem getEntity(OrderItem orderItem) {
        return null;
    }

    @Transactional
    public OrderItem getEntity(Serializable id) {
        return iOrderItemDao.getEntity(id);
    }

    @Transactional
    public OrderItem loadEntity(Serializable id) {
        return iOrderItemDao.loadEntity(id);
    }

    @Transactional
    public OrderItem updateEntity(OrderItem orderItem) {
        return iOrderItemDao.updateEntity(orderItem);
    }

    @Transactional
    public OrderItem deleteEntity(OrderItem orderItem) {
        return iOrderItemDao.deleteEntity(orderItem);
    }

    @Transactional
    public Serializable insertEntity(OrderItem orderItem) {
        return iOrderItemDao.insertEntity(orderItem);
    }

    @Transactional
    public List<OrderItem> getEntities() {
        return iOrderItemDao.getEntities();
    }

    @Transactional
    public List<OrderItem> getEntities(int from, int size) {
        return iOrderItemDao.getEntities(from, size);
    }
}
