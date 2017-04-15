package common.dto.cart;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/4/14.
 */
@Data
public class CartInfoDTO {

    private String seller_id;

    private String seller_account;

    private String seller_name;

    private String img_src;

    private String product_name;

    private String item_type;

    private BigDecimal item_price;

    private int number;

    private String item_id;

}
