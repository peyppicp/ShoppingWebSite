package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by peyppicp on 2017/4/1.
 */
@Controller
public class TabController {

    @RequestMapping(value = "/load-page.action", method = RequestMethod.GET)
    public ModelAndView getCorrespondingPage(@RequestParam String pageName) {
        return new ModelAndView("/WEB-INF/" + pageName + ".html");
    }
}
