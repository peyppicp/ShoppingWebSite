package controller.deal;

import common.dto.common.BaseMessageDTO;
import common.entity.deal.Favorite;
import common.entity.goods.Item;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.deal.IFavouriteService;
import service.goods.IItemService;
import service.system.IUserService;
import utils.TokenUtils;

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

    @RequestMapping(value = "/add-favourite.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doAddFavourite(@CookieValue String token, @RequestParam String item_id) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        Favorite favourite = new Favorite();
        Item item = iItemService.getEntity(item_id);
        User user = iUserService.getEntity(user_id);
        favourite.setUser(user);
        favourite.setItem(item);
        iFavouriteService.insertEntity(favourite);
        BaseMessageDTO baseMessageDTO = new BaseMessageDTO();
//        baseMessageDTO.setMessage("success");
//        baseMessageDTO.setStatus("ok");
        return baseMessageDTO;
    }
}
