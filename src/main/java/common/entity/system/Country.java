package common.entity.system;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by peyppicp on 2017/3/8.
 */
@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "country_num")
    private BigDecimal country_num;

    @Column(name = "country_name")
    private String country_name;

}
