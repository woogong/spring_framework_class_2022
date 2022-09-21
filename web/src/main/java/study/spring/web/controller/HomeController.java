package study.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String first() {
        return "first-page";
    }

    @RequestMapping(value = {"/second", "/second-page", "/list"} )
    public ModelAndView second() {
        ModelAndView mv = new ModelAndView("second-page");
        List<String> list = new ArrayList<>();
        list.add("Korea");
        list.add("GB");
        list.add("France");

        mv.addObject("color", "노란색");
        mv.addObject("countries", list);

        return mv;
    }
}
