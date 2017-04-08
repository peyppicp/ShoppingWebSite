package common.entity.goods;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by peyppicp on 2017/3/25.
 */
@Data
@Entity
@Table(name = "image")

public class Image {

    @Id
    private String image_id;

    private String image_src;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Item.class)
    @JoinColumn(name = "item_id")
    private Item item;
}
