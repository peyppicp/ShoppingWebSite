package common.dao.test;

import common.entity.system.Country;

/**
 * Created by peyppicp on 2017/3/8.
 */
public interface ICountryDao {

    int save(Country country);

    Country get(long id);
}
