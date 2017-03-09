package common.entity.system;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.metamodel.Type;
import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/3/8.
 */
@Data
@Entity
@Table(name = "province")
public class Province {

    @Id
    @Column(name = "prov_num")
    private BigDecimal prov_num;

    @Column(name = "prov_name")
    private String prov_name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Country.class)
    @JoinColumn(name = "country_num")
    private Country country;
}
