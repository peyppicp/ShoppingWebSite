package common.dto.favourite;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/4/13.
 */
@Data
public class FavouriteInfoDTO {

    private BigDecimal item_price;

    private String product_name;

    private String img_src;

    private String item_id;
}
