package controller.system.User;

import com.fasterxml.jackson.databind.util.JSONPObject;
import common.entity.system.User;
import common.enums.RegisterEnum;
import common.enums.UserSellerStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.system.IUserService;
import utils.PrimaryKeyGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by peyppicp on 2017/3/14.
 */
@Controller
public class RegisterController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public void executeRegister(@RequestParam String userAccount, @RequestParam String userPassword,
                                @RequestParam String userNickName, @RequestParam String userRealName,
                                @RequestParam String userPhoneNum, @RequestParam String userEmail,
                                @RequestParam HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = new User();
        user.setUser_id(PrimaryKeyGenerator.uuid());
        user.setUser_account(userAccount);
        user.setUser_password(userPassword);
        user.setUser_nickname(userNickName);
        user.setUser_realname(userRealName);
        user.setUser_phonenum(userPhoneNum);
        user.setUser_email(userEmail);
        user.setUser_credit(0);
        user.setUser_points(0);
        user.setUser_seller_status(UserSellerStatusEnum.FALSE.getStatus());
        //TODO
        user.setUser_key("");
        RegisterEnum register = iUserService.register(user);
        System.out.println(register.getMessage());
    }
}
