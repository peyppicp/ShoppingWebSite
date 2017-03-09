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
@Table(name = "country")
@ToString(exclude = "provinces")
public class Country {

    @Id
    @Column(name = "country_num")
    private BigDecimal country_num;

    @Column(name = "country_name")
    private String country_name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Province.class)
    @JoinColumn(name = "country_num")
    private List<Province> provinces;

}
