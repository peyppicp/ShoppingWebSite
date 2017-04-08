package common.dto.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/4/5.
 */
@Data
public class ProductInfoDTO {

    private String product_id;

    private String product_name;

    private BigDecimal product_number;

    private String description;

    private String advertisement;

}
