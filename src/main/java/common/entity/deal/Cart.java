package common.entity.deal;

import common.entity.goods.Item;
import common.entity.system.User;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Data
@Entity
@Table(name = "cart")
@ToString(exclude = {"user", "item"})
public class Cart implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "buyer_id")
    private User user;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Item.class)
    @JoinColumn(name = "item_id")
    private Item item;

    private int number;
}

