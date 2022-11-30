package study.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.spring.web.domain.Calculation;
import study.spring.web.domain.Song;
import study.spring.web.service.SongService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestfulController {
    private SongService songService;

    @Autowired
    public void setSongService(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/add")
    public Calculation add(@RequestParam("op1") int op1,
                   @RequestParam("op2") int op2) {
        Calculation calculation = new Calculation();
        calculation.setOperand1(op1);
        calculation.setOperand2(op2);
        calculation.setOperator("+");
        calculation.setResult(op1 + op2);

        return calculation;
    }

    @GetMapping("/subtract")
    public Calculation subtract(@RequestParam("op1") int op1,
                           @RequestParam("op2") int op2) {
        Calculation calculation = new Calculation();
        calculation.setOperand1(op1);
        calculation.setOperand2(op2);
        calculation.setOperator("-");
        calculation.setResult(op1 - op2);

        return calculation;
    }

    @GetMapping("/song-list")
    public List<Song> songList(@RequestParam(value = "type", defaultValue = "제목") String type,
                               @RequestParam(value = "query", required = false) String query) {
        List<Song> list = null;
        if (query != null && query.length() > 0) {
            if (type.equals("발표년도")) {
                int year = Integer.parseInt(query);
                list = songService.getList(year);
            } else {
                list = songService.getList(query);
            }
        } else {
            list = songService.getList();
        }

        return list;
    }
}
