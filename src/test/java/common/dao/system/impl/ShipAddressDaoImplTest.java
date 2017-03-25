package common.dao.system.impl;

import common.dao.system.IShipAddressDao;
import common.entity.system.ShipAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import utils.PrimaryKeyGenerator;

import static org.junit.Assert.*;

/**
 * Created by peyppicp on 2017/3/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/dev/spring/spring.xml"})
public class ShipAddressDaoImplTest {

    @Autowired
    private IShipAddressDao iShipAddressDao;

    @Test
    public void getEntity() throws Exception {

    }

    @Test
    public void loadEntity() throws Exception {

    }

    @Test
    public void updateEntity() throws Exception {

    }

    @Test
    public void deleteEntity() throws Exception {

    }

    @Test
    @Transactional
    public void insertEntity() throws Exception {
        ShipAddress shipAddress = new ShipAddress();
        shipAddress.setAddr_id(PrimaryKeyGenerator.uuid());
        iShipAddressDao.insertEntity(shipAddress);
    }

    @Test
    public void getEntities() throws Exception {

    }

    @Test
    public void getEntities1() throws Exception {

    }

}