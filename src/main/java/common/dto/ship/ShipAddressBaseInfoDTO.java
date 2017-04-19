package common.dto.ship;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/4/15.
 */
@Data
public class ShipAddressBaseInfoDTO {

    private String country;

    private String province;

    private String city;

    private String district;

    private BigDecimal zip;

    private String address;

    private String phonenum;

    private String name;

    private String id;
}
