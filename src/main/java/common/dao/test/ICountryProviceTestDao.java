package common.dao.test;

import common.entity.system.City;
import common.entity.system.Country;
import common.entity.system.Province;

/**
 * Created by peyppicp on 2017/3/8.
 */
public interface ICountryProviceTestDao {

    int test(Country country, Province province, City city);

    void test1();
}
