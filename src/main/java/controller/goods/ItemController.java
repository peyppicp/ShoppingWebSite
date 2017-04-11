package controller.goods;

import common.dto.common.BaseMessageDTO;
import common.dto.item.ItemCardInfoDTO;
import common.dto.item.ItemDetailedInfoDTO;
import common.dto.item.ItemInfoDTO;
import common.entity.goods.Image;
import common.entity.goods.Item;
import common.entity.goods.Product;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/get-item-info.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ItemDetailedInfoDTO doGetItemInfo(String item_id) {
        ItemDetailedInfoDTO dto = new ItemDetailedInfoDTO();
        Item item = iItemService.getEntity(item_id);
        Product product = item.getProduct();
        List<Image> imageList = product.getImageList();
        String[] images_url = new String[imageList.size()];
        for (int i = 0; i < imageList.size(); i++) {
            images_url[i] = imageList.get(i).getImage_src();
        }
        dto.setItem_name(product.getProduct_name());
        dto.setItem_description(product.getDescription());
        dto.setItem_price(item.getPrice());
        dto.setItem_inventory(item.getInventory());
        dto.setItem_type(item.getType());
        dto.setItem_size(item.getSize());
        dto.setImage_url(images_url);
        dto.setAdvertisement(product.getAdvertisement());
        return dto;
    }

    @RequestMapping(value = "/get-items-card.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<ItemCardInfoDTO> doGetItemCards() {
        List<ItemCardInfoDTO> dtos = new ArrayList<ItemCardInfoDTO>();
        List<Product> entities = iProductService.getEntities();
        for (Product product : entities) {
            ItemCardInfoDTO itemCardInfoDTO = new ItemCardInfoDTO();
            User user = product.getUser();
            List<Item> itemList = product.getItemList();
            if (itemList == null || itemList.size() == 0) {
                continue;
            }
//            每一个产品的第一个商品将作为展示商品
            Item item = itemList.get(0);

            List<Image> imageList = product.getImageList();
            if (imageList == null || imageList.size() == 0) {
                continue;
            }
            String product_name = product.getProduct_name();
            itemCardInfoDTO.setProduct_name(product_name);
            itemCardInfoDTO.setPrice(item.getPrice());
            itemCardInfoDTO.setBuyer_number(10);
            itemCardInfoDTO.setSeller_address("TestAddresss");
            itemCardInfoDTO.setSeller_name(user.getUser_account());
            itemCardInfoDTO.setImg_url(imageList.get(0).getImage_src());
            itemCardInfoDTO.setItem_id(item.getItem_id());
            itemCardInfoDTO.setSeller_id(user.getUser_id());
            dtos.add(itemCardInfoDTO);
        }
        return dtos;
    }

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
                itemInfoDTO.setProduct_name(key.getProduct_name());
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

    @RequestMapping(value = "/update-item.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doUpdateItem(@RequestParam String productId, @RequestParam BigDecimal itemPrice,
                                       @RequestParam String itemType, @RequestParam String itemSize,
                                       @RequestParam int itemInventory, @RequestParam int itemBreakable,
                                       @RequestParam String itemId) {
        Item entity = iItemService.getEntity(itemId);
        entity.setBreakable(itemBreakable);
        entity.setPrice(itemPrice);
        entity.setInventory(itemInventory);
        entity.setType(itemType);
        entity.setSize(itemSize);
        iItemService.updateEntity(entity);
        return null;
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

    @RequestMapping(value = "/delete-item.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doDeleteItem(@RequestParam String item_id) {
        Item entity = iItemService.getEntity(item_id);
        iItemService.deleteEntity(entity);
        return null;
    }

    @RequestMapping(value = "/get-item-id.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ItemInfoDTO doGetItemById(@RequestParam String item_id) {
        Item item = iItemService.getEntity(item_id);
        ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
        itemInfoDTO.setItem_id(item.getItem_id());
        itemInfoDTO.setItem_breakable(item.getBreakable());
        itemInfoDTO.setItem_size(item.getSize());
        itemInfoDTO.setProduct_id(item.getProduct().getProduct_id());
        itemInfoDTO.setItem_type(item.getType());
        itemInfoDTO.setItem_price(item.getPrice());
        itemInfoDTO.setItem_inventory(item.getInventory());
        return itemInfoDTO;
    }
}
