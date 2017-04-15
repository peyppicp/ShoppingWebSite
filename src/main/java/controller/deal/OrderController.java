package controller.deal;

import common.dto.common.BaseMessageDTO;
import common.entity.deal.Order;
import common.entity.deal.OrderItem;
import common.entity.goods.Item;
import common.entity.system.User;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.deal.ICartService;
import service.deal.IOrderItemService;
import service.deal.IOrderService;
import service.goods.IItemService;
import service.system.IUserService;
import utils.PrimaryKeyGenerator;
import utils.TokenUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Iterator;

/**
 * Created by peyppicp on 2017/4/15.
 */
@Controller
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IItemService iItemService;

    @Autowired
    private IOrderItemService iOrderItemService;

    @Autowired
    private ICartService iCartService;

    @RequestMapping(value = "/create-order.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doCreateOrder(@CookieValue String token, @RequestParam String items) {
        String user_id = TokenUtils.getUserIdFromToken(token);
        User user = iUserService.loadEntity(user_id);
        JSONArray objects = new JSONArray(items);
        Iterator<Object> iterator = objects.iterator();
        Order order = new Order();
        String order_id = PrimaryKeyGenerator.uuid();
        order.setOrder_id(order_id);
        order.setCreated_time(new Timestamp(System.currentTimeMillis()));
        float sum = 0;
        while (iterator.hasNext()) {
            String item_id = (String) iterator.next();
            Item item = iItemService.loadEntity(item_id);
            User seller = item.getProduct().getUser();
            int number = iCartService.getNumber(item, seller);
            BigDecimal price = item.getPrice();
            sum = sum + number * price.floatValue();
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder_item_id(PrimaryKeyGenerator.uuid());
            orderItem.setOrder_id(order_id);
            orderItem.setItem_id(item_id);
            orderItem.setItem_num(number);
            iOrderItemService.insertEntity(orderItem);
        }
        order.setTotal_price(sum);
        order.setBuyer(user);
        iOrderService.insertEntity(order);
        BaseMessageDTO baseMessageDTO = new BaseMessageDTO();
        baseMessageDTO.setStatus("ok");
        baseMessageDTO.setMessage("success");
        return baseMessageDTO;
    }
}
