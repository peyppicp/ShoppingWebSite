package common.dao.system.impl;

import common.dao.system.IUserDao;
import common.entity.system.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/14.
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean isExist(User user) {
        List<User> list = null;
        if (null != user.getUser_account() || "".equals(user.getUser_account())) {
            String hql = "from User where user_account = ?1";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter("1", user.getUser_account());
            list = query.list();
            if (list.size() == 0) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public User getEntity(User user) {
        List<User> list = null;
        if (null != user.getUser_account() || "".equals(user.getUser_account())) {
            String hql = "from User where user_account = ?1";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            query.setParameter("1", user.getUser_account());
            list = query.list();
            if (list.size() == 1) {
                return list.get(0);
            } else {
                return null;
            }
        }
        return null;
    }

    public User getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public User loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(User.class, id);
    }

    public User updateEntity(User user) {
        sessionFactory.getCurrentSession().update(user);
        return user;
    }

    public User deleteEntity(User user) {
        sessionFactory.getCurrentSession().delete(user);
        return user;
    }

    public Serializable insertEntity(User user) {
        return sessionFactory.getCurrentSession().save(user);
    }


    public List<User> getEntities() {
        String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<User> getEntities(int from, int size) {
        String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
