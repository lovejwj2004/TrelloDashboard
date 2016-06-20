package chne.travelsky.flight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lovejwj2004 on 2016/6/14.
 */
@Controller
@RequestMapping("/test")
public class IndexController {
    @RequestMapping("/index")
    public String greeting( Model model) {
        return "index";
    }
}
