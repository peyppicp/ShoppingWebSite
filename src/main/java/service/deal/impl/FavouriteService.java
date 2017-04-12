package service.deal.impl;

import common.dao.deal.IFavouriteDao;
import common.entity.deal.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.deal.IFavouriteService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/12.
 */
@Service
public class FavouriteService implements IFavouriteService {

    @Autowired
    private IFavouriteDao iFavouriteDao;

    @Transactional
    public Favorite getEntity(Favorite favorite) {
        return null;
    }

    @Transactional
    public Favorite getEntity(Serializable id) {
        return iFavouriteDao.getEntity(id);
    }

    @Transactional
    public Favorite loadEntity(Serializable id) {
        return iFavouriteDao.loadEntity(id);
    }

    @Transactional
    public Favorite updateEntity(Favorite favorite) {
        return iFavouriteDao.updateEntity(favorite);
    }

    @Transactional
    public Favorite deleteEntity(Favorite favorite) {
        return iFavouriteDao.deleteEntity(favorite);
    }

    @Transactional
    public Serializable insertEntity(Favorite favorite) {
        return iFavouriteDao.insertEntity(favorite);
    }

    @Transactional
    public List<Favorite> getEntities() {
        return iFavouriteDao.getEntities();
    }

    @Transactional
    public List<Favorite> getEntities(int from, int size) {
        return iFavouriteDao.getEntities(from, size);
    }
}

