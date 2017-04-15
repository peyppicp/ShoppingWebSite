package service.system.impl;

import common.dao.system.IShipAddressDao;
import common.entity.system.ShipAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.system.IShipAddressService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/15.
 */
@Service
public class ShipAddressServiceImpl implements IShipAddressService {

    @Autowired
    private IShipAddressDao iShipAddressDao;

    public ShipAddress getEntity(ShipAddress shipAddress) {
        return null;
    }

    @Transactional
    public ShipAddress getEntity(Serializable id) {
        return iShipAddressDao.getEntity(id);
    }

    @Transactional
    public ShipAddress loadEntity(Serializable id) {
        return iShipAddressDao.loadEntity(id);
    }

    @Transactional
    public ShipAddress updateEntity(ShipAddress shipAddress) {
        return iShipAddressDao.updateEntity(shipAddress);
    }

    @Transactional
    public ShipAddress deleteEntity(ShipAddress shipAddress) {
        return iShipAddressDao.deleteEntity(shipAddress);
    }

    @Transactional
    public Serializable insertEntity(ShipAddress shipAddress) {
        return iShipAddressDao.insertEntity(shipAddress);
    }

    @Transactional
    public List<ShipAddress> getEntities() {
        return iShipAddressDao.getEntities();
    }

    @Transactional
    public List<ShipAddress> getEntities(int from, int size) {
        return iShipAddressDao.getEntities(from, size);
    }
}
