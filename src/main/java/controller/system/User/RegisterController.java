package controller.system.User;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.system.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by peyppicp on 2017/3/14.
 */
@Controller
public class RegisterController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/register")
    @ResponseBody
    public JSONPObject executeRegister(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
