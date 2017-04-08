package controller.system.User;

import common.entity.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.system.IUserService;

import javax.servlet.http.HttpSession;

/**
 * Created by peyppicp on 2017/3/31.
 */
@Controller
public class BackController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/back-login.action", method = RequestMethod.POST)
    public ModelAndView dologin(@RequestParam String name, @RequestParam String password, HttpSession session) {
        User user = new User();
        user.setUser_account(name);
        User entity = iUserService.getEntity(user);
        if (entity.getUser_password().equals(password)) {
            session.setAttribute("user", entity);
            return new ModelAndView("/WEB-INF/boot-back-index.html");
        }
        return new ModelAndView("boot-back-login.html");
    }
}
