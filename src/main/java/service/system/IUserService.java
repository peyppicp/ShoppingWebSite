package service.system;

import common.dao.BasicDao;
import common.entity.system.User;
import common.enums.RegisterEnum;
import service.BasicService;

/**
 * Created by peyppicp on 2017/3/14.
 */
public interface IUserService extends BasicService<User> {

    RegisterEnum register(User user);

    boolean isExist(User user);
}
