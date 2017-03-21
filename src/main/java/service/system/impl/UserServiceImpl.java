package service.system.impl;

import com.google.common.collect.ImmutableMap;
import common.dao.system.IUserDao;
import common.entity.system.User;
import common.enums.RegisterEnum;
import service.system.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by peyppicp on 2017/3/14.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Transactional
    public RegisterEnum register(User user) {
        try {
            boolean isExist = iUserDao.isExist(user);
            if (isExist) {
                return RegisterEnum.EXISTED;
            }
            iUserDao.insertEntity(user);
            return RegisterEnum.SUCCESS;
        } catch (Exception e) {
            return RegisterEnum.UNKNOWEN;
        }
    }

    @Transactional
    public User login(User user) {
        return iUserDao.getEntity(user);
    }

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
