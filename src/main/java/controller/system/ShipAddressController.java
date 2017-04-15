package controller.system;

import common.dao.system.IShipAddressDao;
import common.dto.ship.ShipAddressBaseInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.system.IUserService;
import utils.TokenUtils;

/**
 * Created by peyppicp on 2017/4/15.
 */
@Controller
public class ShipAddressController {

    @Autowired
    private IShipAddressDao iShipAddressDao;

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/get-ship.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ShipAddressBaseInfoDTO doGetShip(@CookieValue String token) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        return null;
    }
}
