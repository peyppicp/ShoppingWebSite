package common.dto.product;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/4/4.
 */
@Data
public class ModifyProductDTO {

    private String id;

    private String name;

    private BigDecimal number;

    private String description;

    private String advertisement;

}
