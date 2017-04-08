package common.dao.goods.impl;

import common.dao.goods.IProductDao;
import common.entity.goods.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/1.
 */
@Repository
public class ProductDaoImpl implements IProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean isExist(Product product) {
        return false;
    }

    public Product getEntity(Product product) {
        return null;
    }

    public Product getEntity(Serializable id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    public Product loadEntity(Serializable id) {
        return sessionFactory.getCurrentSession().load(Product.class, id);
    }

    public Product updateEntity(Product product) {
        sessionFactory.getCurrentSession().update(product);
        return product;
    }

    public Product deleteEntity(Product product) {
        sessionFactory.getCurrentSession().delete(product);
        return product;
    }

    public Serializable insertEntity(Product product) {
        return sessionFactory.getCurrentSession().save(product);
    }

    public List<Product> getEntities() {
        String hql = "from Product";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public List<Product> getEntities(int from, int size) {
        String hql = "from Product";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(from);
        query.setMaxResults(size);
        return query.list();
    }

    public Product getProductByNameAndUserId(String userId, String name) {
        String hql = "from Product where seller_id=? and product_name=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, userId);
        query.setParameter(1, name);
        return (Product) query.uniqueResult();
    }
}
