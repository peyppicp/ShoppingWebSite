package common.entity.deal;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Data
@Entity
@Table(name = "delivery")
@ToString(exclude = {"deliverList", "order"})
public class Delivery {

    @Id
    private String delivery_id;

    private float delivery_price;

    private String delivery_status;

    private String delivery_details;

    private String delivery_company;

    private String delivery_inquirynum;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Deliver.class)
    @JoinColumn(name = "delivery_id")
    private List<Deliver> deliverList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order order;
}

