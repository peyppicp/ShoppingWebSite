package common.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by peyppicp on 2017/3/8.
 */
@Entity
@Table(name = "test_table")
@Data
public class TestObject {

    @Id
    private long id;

    private Date date;

}
