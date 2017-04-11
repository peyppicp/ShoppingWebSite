package common.dto.item;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/4/9.
 */
@Data
public class ItemCardInfoDTO {

    private String img_url;

    private BigDecimal price;

    private int buyer_number;

    private String product_name;

    private String seller_name;

    private String seller_address;

    private String item_id;

    private String seller_id;

}
