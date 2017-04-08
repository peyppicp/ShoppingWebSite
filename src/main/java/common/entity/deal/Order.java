package common.entity.deal;

import common.entity.system.User;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Data
@Entity
@Table(name = "orders")
@ToString(exclude = {"buyer", "seller", "deliveryList"})
public class Order {

    @Id
    private String order_id;

    private String delivery_status;

    private Timestamp created_time;

    private Timestamp paid_time;

    private Timestamp finished_time;

    private float good_price;

    private float delivery_price;

    private float good_discount;

    private float delivery_discount;

    private float total_price;

    @Type(type = "text")
    private String comment_1;

    private Timestamp comment_1_time;

    @Type(type = "text")
    private String comment_2;

    private Timestamp comment_2_time;

    @Type(type = "text")
    private String payment_detail;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    private String buyer_address;

    private String buyer_phonenum;

    private String buyer_name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "seller_id")
    private User seller;

    private String seller_address;

    private String sellert_phonenum;

    private String seller_name;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Delivery.class, mappedBy = "order")
//    @JoinColumn(name = "order_id")
    private List<Delivery> deliveryList;
}
