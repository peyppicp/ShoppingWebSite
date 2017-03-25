package common.dto.User;

import lombok.Data;

/**
 * Created by peyppicp on 2017/3/23.
 */
@Data
public class UserCheckDTO {

    private String message;

    private String error_message;

    private int status;
}
