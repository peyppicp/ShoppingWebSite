package common.entity.deal;

import common.entity.goods.Item;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Data
@Entity
@Table(name = "deliver")
@ToString(exclude = {"item", "delivery"})
public class Deliver implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Item.class)
    @JoinColumn(name = "item_id")
    private Item item;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Delivery.class)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
