package controller.goods;

import common.dto.common.BaseMessageDTO;
import common.dto.product.ModifyProductDTO;
import common.dto.product.ProductInfoDTO;
import common.entity.goods.Product;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.goods.IProductService;
import service.system.IUserService;
import utils.PrimaryKeyGenerator;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peyppicp on 2017/4/1.
 */
@Controller
public class ProductController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "/get-product-id.action", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ProductInfoDTO doGetProductById(@RequestParam String product_id) {
        Product entity = iProductService.loadEntity(product_id);
//        TODO 检查返回值是否为空
        ProductInfoDTO productInfoDTO = new ProductInfoDTO();
        productInfoDTO.setProduct_id(entity.getProduct_id());
        productInfoDTO.setProduct_number(entity.getProduct_number());
        productInfoDTO.setProduct_name(entity.getProduct_name());
        productInfoDTO.setAdvertisement(entity.getAdvertisement());
        productInfoDTO.setDescription(entity.getDescription());
        return productInfoDTO;
    }

    @RequestMapping(value = "/get-product.action", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<ProductInfoDTO> doGetProduct(HttpSession session) {
        User user = (User) session.getAttribute("user");
        User entity = iUserService.loadEntity(user.getUser_id());
        List<Product> productList = entity.getProductList();
        List<ProductInfoDTO> productInfoDTOs = new ArrayList<ProductInfoDTO>();
        for (Product product : productList) {
            ProductInfoDTO productInfoDTO = new ProductInfoDTO();
            productInfoDTO.setProduct_id(product.getProduct_id());
            productInfoDTO.setProduct_name(product.getProduct_name());
            productInfoDTO.setProduct_number(product.getProduct_number());
            productInfoDTO.setDescription(product.getDescription());
            productInfoDTO.setAdvertisement(product.getAdvertisement());
            productInfoDTOs.add(productInfoDTO);
        }
        return productInfoDTOs;
    }

    @RequestMapping(value = "/get-product-list.action", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<ProductInfoDTO> doGetProductList(HttpSession session) {
        User user = (User) session.getAttribute("user");
        User entity = iUserService.loadEntity(user.getUser_id());
        List<Product> productList = entity.getProductList();
        List<ProductInfoDTO> productInfoDTOs = new ArrayList<ProductInfoDTO>();
        for (Product product : productList) {
            ProductInfoDTO productInfoDTO = new ProductInfoDTO();
            productInfoDTO.setProduct_id(product.getProduct_id());
            productInfoDTO.setProduct_name(product.getProduct_name());
            productInfoDTO.setProduct_number(product.getProduct_number());
            productInfoDTO.setDescription(product.getDescription());
            productInfoDTOs.add(productInfoDTO);
        }
        return productInfoDTOs;
    }

    @RequestMapping(value = "/add-product.action", method = RequestMethod.POST)
    @ResponseBody
    public String doAddProduct(@RequestParam String productName, @RequestParam BigDecimal productNumber,
                               @RequestParam String productDescription, @RequestParam String advertisement,
                               HttpSession session) {
        User entity = (User) session.getAttribute("user");
        Product product = new Product();
        product.setProduct_id(PrimaryKeyGenerator.uuid());
        product.setProduct_name(productName);
        product.setProduct_number(productNumber);
        product.setDescription(productDescription);
        product.setAdvertisement(advertisement);
        product.setUser(entity);
        iProductService.insertEntity(product);
        return "111";
    }

    @RequestMapping(value = "/update-product.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doModifyProduct(@RequestParam String productId, @RequestParam String productName,
                                          @RequestParam String productDescription, @RequestParam BigDecimal productNumber,
                                          @RequestParam String advertisement) {
        Product product = iProductService.loadEntity(productId);
        product.setProduct_name(productName);
        product.setDescription(productDescription);
        product.setProduct_number(productNumber);
        product.setAdvertisement(advertisement);
        iProductService.updateEntity(product);
        BaseMessageDTO baseMessageDTO = new BaseMessageDTO();
        baseMessageDTO.setMessage("success");
        baseMessageDTO.setStatus("ok");
        return baseMessageDTO;
    }

    @RequestMapping(value = "/delete-product.action", method = RequestMethod.POST)
    @ResponseBody
    public BaseMessageDTO doDeleteProduct(@RequestParam String product_id, HttpSession session) {
        Product product = iProductService.loadEntity(product_id);
        User user = (User) session.getAttribute("user");
        if (product.getUser().getUser_id().equals(user.getUser_id())) {
            iProductService.deleteEntity(product);
            BaseMessageDTO baseMessageDTO = new BaseMessageDTO();
            baseMessageDTO.setMessage("success");
            baseMessageDTO.setStatus("ok");
//            return 操作成功！
            return baseMessageDTO;
        }
//        非法操作
        return null;
    }
}
