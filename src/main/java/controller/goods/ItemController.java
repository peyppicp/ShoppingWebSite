package controller.goods;

import common.dto.common.BaseMessageDTO;
import common.dto.item.ItemInfoDTO;
import common.entity.goods.Item;
import common.entity.goods.Product;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.goods.IItemService;
import service.goods.IProductService;
import service.system.IUserService;
import utils.PrimaryKeyGenerator;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by peyppicp on 2017/4/1.
 */
@Controller
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "/get-items.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<ItemInfoDTO> doGetItems(HttpSession session) {
        User user = (User) session.getAttribute("user");
        User entity = iUserService.getEntity(user.getUser_id());
        List<Product> productList = entity.getProductList();
        Map<Product, List<Item>> map = new HashMap<Product, List<Item>>();
        ArrayList<ItemInfoDTO> itemInfoDTOArrayList = new ArrayList<ItemInfoDTO>();
        for (Product product : productList) {
            map.put(product, product.getItemList());
        }
        Iterator<Map.Entry<Product, List<Item>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Product, List<Item>> entry = iterator.next();
            Product key = entry.getKey();
            List<Item> value = entry.getValue();
            for (Item item : value) {
                ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
                itemInfoDTO.setProduct_id(key.getProduct_id());
                itemInfoDTO.setItem_breakable(item.getBreakable());
                itemInfoDTO.setItem_id(item.getItem_id());
                itemInfoDTO.setItem_inventory(item.getInventory());
                itemInfoDTO.setItem_price(item.getPrice());
                itemInfoDTO.setItem_type(item.getType());
                itemInfoDTO.setItem_size(item.getSize());
                itemInfoDTOArrayList.add(itemInfoDTO);
            }
        }
        return itemInfoDTOArrayList;
    }

    @RequestMapping(value = "/add-item.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doInsertItem(@RequestParam String productId, @RequestParam BigDecimal itemPrice,
                                       @RequestParam String itemType, @RequestParam String itemSize,
                                       @RequestParam int itemInventory, @RequestParam int itemBreakable,
                                       HttpSession session) {
        Product product = iProductService.getEntity(productId);
        Item item = new Item();
        item.setItem_id(PrimaryKeyGenerator.uuid());
        item.setSize(itemSize);
        item.setType(itemType);
        item.setInventory(itemInventory);
        item.setPrice(itemPrice);
        item.setBreakable(itemBreakable);
        item.setProduct(product);
        iItemService.insertEntity(item);
        return null;
    }
}
