package controller.deal;

import common.dao.deal.ICartDao;
import common.dto.common.BaseMessageDTO;
import common.entity.deal.Cart;
import common.entity.goods.Item;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.deal.ICartService;
import service.goods.IItemService;
import service.system.IUserService;
import utils.TokenGenerator;
import utils.TokenUtils;

/**
 * Created by peyppicp on 2017/4/12.
 */
@Controller
public class CartController {

    @Autowired
    private ICartService iCartService;

    @Autowired
    private IItemService iItemService;

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/add-cart.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doAddCart(@CookieValue String token, @RequestParam String item_id,
                                    @RequestParam int number) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        Item item = iItemService.getEntity(item_id);
        User user = iUserService.getEntity(user_id);
        Cart cart = new Cart();
        cart.setItem(item);
        cart.setUser(user);
        cart.setNumber(number);
        iCartService.insertEntity(cart);
        BaseMessageDTO baseMessageDTO = new BaseMessageDTO();
        baseMessageDTO.setMessage("success");
        baseMessageDTO.setStatus("ok");
        return baseMessageDTO;
    }
}
