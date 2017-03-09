package common.entity.system;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/3/9.
 */
@Data
@Entity
@Table(name = "district")
public class District {

    @Id
    @Column(name = "district_num")
    private BigDecimal district_num;

    @Column(name = "district_name")
    private String district_name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = City.class)
    @JoinColumn(name = "city_num")
    private City city;
}
