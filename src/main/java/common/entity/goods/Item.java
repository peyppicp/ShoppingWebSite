package common.entity.goods;

import common.entity.deal.Cart;
import common.entity.deal.Deliver;
import common.entity.deal.Favorite;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Data
@Entity
@Table(name = "item")
@ToString(exclude = {"product", "imageList", "cartList", "favoriteList"})
public class Item {

    @Id
    private String item_id;

    private BigDecimal price;

    private int inventory;

    private String type;

    private String size;

    private int breakable;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Image.class, mappedBy = "item")
    private List<Image> imageList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Cart.class, mappedBy = "item")
    private List<Cart> cartList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Favorite.class, mappedBy = "item")
    private List<Favorite> favoriteList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Deliver.class, mappedBy = "item")
//    @JoinColumn(name =
    private List<Deliver> deliverList;
}
