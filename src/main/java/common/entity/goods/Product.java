package common.entity.goods;

import common.entity.system.User;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Data
@Entity
@Table(name = "product")
@ToString(exclude = {"user", "productCatetgoryList", "itemList", "imageList"})
public class Product {

    @Id
    @Column(name = "product_id")
    private String product_id;

    @Column(name = "product_number")
    private BigDecimal product_number;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "description")
    private String description;

    @Column(name = "advertisement")
    @Type(type = "text")
    private String advertisement;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "seller_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ProductCatetgory.class, mappedBy = "product")
//    @JoinColumn(name = "product_id")
    private List<ProductCatetgory> productCatetgoryList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Item.class, mappedBy = "product")
//    @JoinColumn(name = "product_id")
    private List<Item> itemList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Image.class, mappedBy = "product")
//    @JoinColumn(name = "product_id")
    private List<Image> imageList;
}
