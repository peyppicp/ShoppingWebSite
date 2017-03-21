package controller.system.User;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.util.JSONPObject;
import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.system.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by peyppicp on 2017/3/14.
 */
@Controller
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView executeLogin(@RequestParam String userAccount, @RequestParam String userPassword,
                                     HttpSession session) {
        User user = new User();
        user.setUser_account(userAccount);
        User login = iUserService.login(user);
        if (login.getUser_password().equals(userPassword)) {
            session.setAttribute("user", login);
            return new ModelAndView("/index.html");
        }
        return null;
    }
}
