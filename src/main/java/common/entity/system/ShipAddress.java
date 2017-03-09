package common.entity.system;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/3/9.
 */
@Data
@Entity
@Table(name = "shipaddress")
public class ShipAddress {

    @Id
    @Column(name = "addr_id")
    private String addr_id;

    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "zip")
    private BigDecimal zip;

    @Column(name = "buyer_address")
    private String buyer_address;

    @Column(name = "buyer_phonenum")
    private String buyer_phonenum;

    @Column(name = "buyer_name")
    private String buyer_name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
}
