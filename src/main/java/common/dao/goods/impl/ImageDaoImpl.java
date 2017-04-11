package common.dao.goods.impl;

import common.dao.goods.IImageDao;
import common.entity.goods.Image;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/9.
 */
//TODO
@Repository
public class ImageDaoImpl implements IImageDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Image getImageByProductItem(String product_id, String item_id) {
        String hql = "from Image where product_id =?1 and item_id =?2";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("1", product_id);
        query.setParameter("2", item_id);
        return (Image) query.uniqueResult();
    }

    public void saveOrUpdateEntity(Image image) {
        sessionFactory.getCurrentSession().saveOrUpdate(image);
    }

    public boolean isExist(Image image) {
        return false;
    }

    public Image getEntity(Image image) {
        return null;
    }

    public Image getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(Image.class, id);
    }

    public Image loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(Image.class, id);
    }

    public Image updateEntity(Image image) {
        sessionFactory.getCurrentSession().update(image);
        return image;
    }

    public Image deleteEntity(Image image) {
        sessionFactory.getCurrentSession().delete(image);
        return image;
    }

    public Serializable insertEntity(Image image) {
        return sessionFactory.getCurrentSession().save(image);
    }

    public List<Image> getEntities() {
        String hql = "from Image";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<Image> getEntities(int from, int size) {
        String hql = "from Image";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }
}
