package common.entity.system;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/8.
 */
@Data
@Entity
@Table(name = "province")
@ToString(exclude = {"country", "cities"})
public class Province {

    @Id
    @Column(name = "prov_num")
    private BigDecimal prov_num;

    @Column(name = "prov_name")
    private String prov_name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Country.class)
    @JoinColumn(name = "country_num")
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = City.class, mappedBy = "province")
//    @JoinColumn(name = "prov_num")
    private List<City> cities;
}
