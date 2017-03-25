package common.entity.goods;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Data
@Entity
@Table(name = "pro_cat")
@ToString(exclude = {"product", "category"})
public class ProductCatetgory implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;
}
