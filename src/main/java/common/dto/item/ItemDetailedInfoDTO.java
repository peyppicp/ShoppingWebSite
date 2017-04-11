package common.dto.item;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/4/11.
 */
@Data
public class ItemDetailedInfoDTO {

    private String item_name;

    private String item_description;

    private BigDecimal item_price;

    private int item_inventory;

    private String item_type;

    private String item_size;

    private String[] image_url;

    private String advertisement;
}
