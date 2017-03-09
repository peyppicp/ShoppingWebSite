package common.entity.system;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/3/9.
 */
@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "city_num")
    private BigDecimal city_num;

    @Column(name = "city_name")
    private String city_name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "prov_num")
    private Province province;
}
