package study.spring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.spring.web.domain.Person;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/now")
    public String now() {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = dateFormat.format(new Date());

        return now;
    }

    @GetMapping("/person")
    public Person person() {
        Person person = new Person();
        person.setName("금현호");
        person.setAge((int)System.currentTimeMillis() % 90 + 10);

        return person;
    }
}
