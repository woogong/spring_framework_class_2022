package study.spring.web.controller;

import org.springframework.web.bind.annotation.*;
import study.spring.web.domain.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/now")
    public String now() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = dateFormat.format(new Date());

        return now;
    }

    @GetMapping("/person")
    public Person person(@RequestParam(value = "name", required = false, defaultValue = "ABCD") String name) {
        Person person = new Person();
        person.setName(name);
        person.setAge((int)System.currentTimeMillis() % 100);

        return person;
    }

}
