package common.entity.goods;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Data
@Entity
@Table(name = "category")
@ToString(exclude = {"productCatetgoryList"})
public class Category {

    @Id
    @Column(name = "category_id")
    private String category_id;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "parent_id")
    private String parent_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ProductCatetgory.class)
    @JoinColumn(name = "category_id")
    private List<ProductCatetgory> productCatetgoryList;
}
