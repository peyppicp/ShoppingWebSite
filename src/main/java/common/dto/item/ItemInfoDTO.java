package common.dto.item;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/4/8.
 */
@Data
public class ItemInfoDTO {

    private String product_id;

    private String item_id;

    private BigDecimal item_price;

    private int item_inventory;

    private String item_type;

    private String item_size;

    private int item_breakable;
}
