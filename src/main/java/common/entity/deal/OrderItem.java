package common.entity.deal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by peyppicp on 2017/4/15.
 */
@Data
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    private String order_item_id;

    private String order_id;

    private String item_id;

    private int item_num;
}
