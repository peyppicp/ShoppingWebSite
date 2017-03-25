package common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/9.
 */
public interface BasicDao<T> {

    /**
     * Check out the existence of the entity.
     *
     * @param t
     * @return
     */
    boolean isExist(T t);

    /**
     * Get T from database.
     *
     * @param t
     * @return
     */
    T getEntity(T t);

    /**
     * No lazy load.Use serializable to get entity.
     *
     * @param id
     * @return
     */
    T getEntity(Serializable id);

    /**
     * Lazy load.Use serializable to get entity.
     *
     * @param id
     * @return
     */
    T loadEntity(Serializable id);

    /**
     * Update entity.Return original entity.
     *
     * @param t
     * @return
     */
    T updateEntity(T t);

    /**
     * Delete entity.Return original entity.
     *
     * @param t
     * @return
     */
    T deleteEntity(T t);

    /**
     * Insert entity.Return number.
     *
     * @param t
     * @return
     */
    Serializable insertEntity(T t);

    /**
     * Get entities.
     *
     * @return
     */
    List<T> getEntities();

    /**
     * Get entities from var1,size var2.
     *
     * @param from
     * @param size
     * @return
     */
    List<T> getEntities(int from, int size);
}
