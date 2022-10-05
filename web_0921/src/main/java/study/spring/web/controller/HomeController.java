package study.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import study.spring.web.domain.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    //@RequestMapping(value = "/hello", method = RequestMethod.POST)
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = {"/hi", "/abcd", "/dgsw.do"})
    public String hi() {
        return "hi";
    }

    @RequestMapping("/clock")
    public ModelAndView clock() {
        ModelAndView mv = new ModelAndView("clock");

        SimpleDateFormat format =
                new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
        String time = format.format(new Date());
        mv.addObject("now", time);

        Person person = new Person();
        person.setName("금현호");
        person.setAge(25);

        mv.addObject("person", person);

        return mv;
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signin-result")
    public ModelAndView signinResult(
            @RequestParam("id") String id
            , @RequestParam("name") String name
            , @RequestParam("city") String city
    ) {
        ModelAndView mv = new ModelAndView("signin-result");

        mv.addObject("id", id);
        mv.addObject("name", name);
        mv.addObject("city", city);

        return mv;
    }
}
