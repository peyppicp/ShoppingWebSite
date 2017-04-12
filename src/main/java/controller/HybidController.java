package controller;

import common.dto.common.BaseMessageDTO;
import common.dto.hybid.FavouriteCarNumberDTO;
import common.entity.deal.Cart;
import common.entity.deal.Favorite;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.deal.IFavouriteService;
import service.system.IUserService;
import utils.TokenUtils;

import java.util.List;

/**
 * Created by peyppicp on 2017/4/12.
 */
@Controller
public class HybidController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/get-favourite-car-number.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public FavouriteCarNumberDTO doGetFavourite(@CookieValue String token) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        User user = iUserService.getEntity(user_id);
//        可写hql进行查询优化 目前的查询相当于select *
        List<Favorite> favoriteList = user.getFavoriteList();
        List<Cart> cartList = user.getCartList();
        FavouriteCarNumberDTO favouriteCarNumberDTO = new FavouriteCarNumberDTO();
        favouriteCarNumberDTO.setCar_num(cartList.size());
        favouriteCarNumberDTO.setFavourite_num(favoriteList.size());
        return favouriteCarNumberDTO;
    }
}
