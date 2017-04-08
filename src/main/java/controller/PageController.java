package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by peyppicp on 2017/4/5.
 */
@Controller
public class PageController {

    @RequestMapping(value = "/getPage.action")
    public ModelAndView doGetPage(@RequestParam String pageName) {
        return new ModelAndView("/WEB-INF/" + pageName + ".html");
    }
}
