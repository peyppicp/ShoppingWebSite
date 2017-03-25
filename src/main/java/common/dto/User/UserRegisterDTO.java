package common.dto.User;

import lombok.Data;

/**
 * Created by peyppicp on 2017/3/23.
 */
@Data
public class UserRegisterDTO {

    //    Token stored in cookie
    private String token;

    // User account name
    private String user_account;

    //    Only success/error/ can choose
    private String message;

    private String error_message;

    //    User status
    private int status;

    //Cookie survival time
    private int cookie_time;
}
