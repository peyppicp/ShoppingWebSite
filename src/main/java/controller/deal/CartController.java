package controller.deal;

import common.dto.cart.CartInfoDTO;
import common.dto.common.BaseMessageDTO;
import common.entity.deal.Cart;
import common.entity.goods.Item;
import common.entity.goods.Product;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.deal.ICartService;
import service.goods.IItemService;
import service.system.IUserService;
import utils.TokenUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Item item = iItemService.loadEntity(item_id);
        User user = iUserService.loadEntity(user_id);
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

    @RequestMapping(value = "/get-cart.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String, List<CartInfoDTO>> doGetCart(@CookieValue String token) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        User user = iUserService.loadEntity(user_id);
        Map<String, List<CartInfoDTO>> map = new HashMap<String, List<CartInfoDTO>>();
        List<Cart> cartList = user.getCartList();
        List<CartInfoDTO> list = new ArrayList<CartInfoDTO>();
        for (Cart cart : cartList) {
            Item item = cart.getItem();
            Product product = item.getProduct();
            User seller = product.getUser();
            CartInfoDTO cartInfoDTO = new CartInfoDTO();
            cartInfoDTO.setSeller_id(seller.getUser_id());
            cartInfoDTO.setSeller_account(seller.getUser_account());
            cartInfoDTO.setSeller_name(seller.getUser_nickname());
            cartInfoDTO.setImg_src(product.getImageList().get(0).getImage_src());
            cartInfoDTO.setProduct_name(product.getProduct_name());
            cartInfoDTO.setItem_type(item.getType());
            cartInfoDTO.setItem_price(item.getPrice());
            cartInfoDTO.setNumber(cart.getNumber());
            cartInfoDTO.setItem_id(item.getItem_id());
            list.add(cartInfoDTO);
            map.put(seller.getUser_id(), list);
        }
        return map;
    }
}
