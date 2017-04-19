package controller.system;

import common.dto.common.BaseMessageDTO;
import common.dto.ship.ShipAddressBaseInfoDTO;
import common.entity.system.ShipAddress;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.system.IShipAddressService;
import service.system.IUserService;
import utils.PrimaryKeyGenerator;
import utils.TokenUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/15.
 */
@Controller
public class ShipAddressController {

    @Autowired
    private IShipAddressService iShipAddressService;

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/get-ship.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<ShipAddressBaseInfoDTO> doGetShip(@CookieValue String token) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        User user = iUserService.getEntity(user_id);
        List<ShipAddress> shipAddresses = user.getShipAddresses();
        List<ShipAddressBaseInfoDTO> dtos = new ArrayList<ShipAddressBaseInfoDTO>();
        for (ShipAddress shipAddress : shipAddresses) {
            ShipAddressBaseInfoDTO dto = new ShipAddressBaseInfoDTO();
            dto.setCountry(shipAddress.getCountry());
            dto.setProvince(shipAddress.getProvince());
            dto.setCity(shipAddress.getCity());
            dto.setDistrict(shipAddress.getDistrict());
            dto.setZip(shipAddress.getZip());
            dto.setAddress(shipAddress.getBuyer_address());
            dto.setPhonenum(shipAddress.getBuyer_phonenum());
            dto.setName(shipAddress.getBuyer_name());
            dto.setId(shipAddress.getAddr_id());
            dtos.add(dto);
        }
        return dtos;
    }

    @RequestMapping(value = "/add-ship.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doAddShip(@CookieValue String token, @RequestParam String country,
                                    @RequestParam String province, @RequestParam String city,
                                    @RequestParam String district, @RequestParam String details,
                                    @RequestParam BigDecimal zip, String phone, String name) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        User user = iUserService.getEntity(user_id);
        ShipAddress shipAddress = new ShipAddress();
        shipAddress.setAddr_id(PrimaryKeyGenerator.uuid());
        shipAddress.setUser(user);
        shipAddress.setCountry(country);
        shipAddress.setProvince(province);
        shipAddress.setCity(city);
        shipAddress.setDistrict(district);
        shipAddress.setZip(zip);
        shipAddress.setBuyer_address(details);
        shipAddress.setBuyer_phonenum(phone);
        shipAddress.setBuyer_name(name);
        iShipAddressService.insertEntity(shipAddress);
        return null;
    }

    @RequestMapping(value = "/delete-ship.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doDeleteShip(@CookieValue String token, @RequestParam String ship_id) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        ShipAddress ship = iShipAddressService.getEntity(ship_id);
        iShipAddressService.deleteEntity(ship);
        return new BaseMessageDTO();
    }
}
