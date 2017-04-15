package controller.deal;

import common.dto.common.BaseMessageDTO;
import common.dto.favourite.FavouriteInfoDTO;
import common.entity.deal.Favorite;
import common.entity.goods.Image;
import common.entity.goods.Item;
import common.entity.goods.Product;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.deal.IFavouriteService;
import service.goods.IItemService;
import service.system.IUserService;
import utils.TokenUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/12.
 */
@Controller
public class FavouriteController {

    @Autowired
    private IFavouriteService iFavouriteService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IItemService iItemService;

    @RequestMapping(value = "/delete-favourite.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doDeleteFavourite(@CookieValue String token, @RequestParam String item_id) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        User user = iUserService.loadEntity(user_id);
        Item item = iItemService.loadEntity(item_id);
        Favorite favorite = new Favorite();
        favorite.setItem(item);
        favorite.setUser(user);
        iFavouriteService.deleteEntity(favorite);
        return null;
    }

    @RequestMapping(value = "/add-favourite.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doAddFavourite(@CookieValue String token, @RequestParam String item_id) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        Favorite favourite = new Favorite();
        Item item = iItemService.loadEntity(item_id);
        User user = iUserService.loadEntity(user_id);
        favourite.setUser(user);
        favourite.setItem(item);
        iFavouriteService.insertEntity(favourite);
        BaseMessageDTO baseMessageDTO = new BaseMessageDTO();
//        baseMessageDTO.setMessage("success");
//        baseMessageDTO.setStatus("ok");
        return baseMessageDTO;
    }

    @RequestMapping(value = "/get-favourite.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<FavouriteInfoDTO> doGetFavourite(@CookieValue String token) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        User user = iUserService.loadEntity(user_id);
        List<Favorite> favoriteList = user.getFavoriteList();
        List<FavouriteInfoDTO> dtos = new ArrayList<FavouriteInfoDTO>();
        for (Favorite favorite : favoriteList) {
            Item item = favorite.getItem();
            Product product = item.getProduct();
            Image image = product.getImageList().get(0);
            BigDecimal price = item.getPrice();
            String name = product.getProduct_name();
            FavouriteInfoDTO favouriteInfoDTO = new FavouriteInfoDTO();
            favouriteInfoDTO.setImg_src(image.getImage_src());
            favouriteInfoDTO.setItem_price(price);
            favouriteInfoDTO.setProduct_name(name);
            favouriteInfoDTO.setItem_id(item.getItem_id());
            dtos.add(favouriteInfoDTO);
        }
        return dtos;
    }
}
