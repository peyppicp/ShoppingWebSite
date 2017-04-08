package common.entity.system;

import common.entity.deal.Cart;
import common.entity.deal.Favorite;
import common.entity.deal.Order;
import common.entity.goods.Product;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/9.
 */
@Data
@Entity
@Table(name = "user")
@ToString(exclude = {"shipAddresses", "productList", "cartList", "favoriteList", "buyerOrderList", "sellerOrderList"})
public class User {

    @Id
    @Column(name = "user_id")
    private String user_id;

    @Column(name = "user_account")
    private String user_account;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "user_nickname")
    private String user_nickname;

    @Column(name = "user_realname")
    private String user_realname;

    @Column(name = "user_phonenum")
    private String user_phonenum;

    @Column(name = "user_email")
    private String user_email;

    @Column(name = "user_credit")
    private Integer user_credit;

    @Column(name = "user_points")
    private Integer user_points;

    @Column(name = "user_seller_status")
    private Boolean user_seller_status;

    @Column(name = "user_address")
    private String user_address;

    @Column(name = "user_idcardnum")
    private String user_idcardnum;

    @Column(name = "user_credit_as_seller")
    private Integer user_credit_as_seller;

    @Column(name = "user_points_as_seller")
    private Integer user_points_as_seller;

    @Column(name = "user_key")
    private String user_key;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ShipAddress.class, mappedBy = "user")
//    @JoinColumn(name = "user_id")
    private List<ShipAddress> shipAddresses;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, targetEntity = Product.class, mappedBy = "user")
//    @JoinColumn(name = "seller_id")
    private List<Product> productList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Cart.class, mappedBy = "user")
//    @JoinColumn(name = "buyer_id")
    private List<Cart> cartList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Favorite.class, mappedBy = "user")
//    @JoinColumn(name = "buyer_id")
    private List<Favorite> favoriteList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Order.class, mappedBy = "buyer")
//    @JoinColumn(name = "buyer_id")
    private List<Order> buyerOrderList;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Order.class, mappedBy = "seller")
//    @JoinColumn(name = "seller_id")
    private List<Order> sellerOrderList;
}
