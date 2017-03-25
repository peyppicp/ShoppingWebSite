package common.entity.goods;

import common.entity.deal.Cart;
import common.entity.deal.Deliver;
import common.entity.deal.Delivery;
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Image.class)
    @JoinColumn(name = "item_id")
    private List<Image> imageList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Cart.class)
    @JoinColumn(name = "item_id")
    private List<Cart> cartList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Favorite.class)
    @JoinColumn(name = "item_id")
    private List<Favorite> favoriteList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Deliver.class)
    @JoinColumn(name = "item_id")
    private List<Deliver> deliverList;
}
