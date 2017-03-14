package service.system.impl;

import common.dao.system.IUserDao;
import common.entity.system.User;
import service.system.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/14.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Transactional
    public User getEntity(Serializable id) {
        return iUserDao.getEntity(id);
    }

    @Transactional
    public User loadEntity(Serializable id) {
        return iUserDao.loadEntity(id);
    }

    @Transactional
    public User updateEntity(User user) {
        return iUserDao.updateEntity(user);
    }

    @Transactional
    public User deleteEntity(User user) {
        return iUserDao.deleteEntity(user);
    }

    @Transactional
    public Serializable insertEntity(User user) {
        return iUserDao.insertEntity(user);
    }

    @Transactional
    public List<User> getEntities() {
        return iUserDao.getEntities();
    }

    @Transactional
    public List<User> getEntities(int from, int size) {
        return iUserDao.getEntities(from, size);
    }
}
