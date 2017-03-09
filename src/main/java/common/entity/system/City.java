package common.entity.system;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/9.
 */
@Data
@Entity
@Table(name = "city")
@ToString(exclude = {"province","districts"})
public class City {

    @Id
    @Column(name = "city_num")
    private BigDecimal city_num;

    @Column(name = "city_name")
    private String city_name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "prov_num")
    private Province province;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = District.class)
    @JoinColumn(name = "city_num")
    private List<District> districts;
}
