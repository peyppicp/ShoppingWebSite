package common.entity.system;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by peyppicp on 2017/3/9.
 */
@Data
@Entity
@Table(name = "user")
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
}
