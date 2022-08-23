package spring.study.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Counter1 extends MyFramework1 {
    protected Map<String, Integer> map;

    public Counter1() {
        super();
        map = new HashMap<>();
    }

    @Override
    protected void doJob(String name) {
        Integer count = map.get(name);
        if (count == null) {
            count = 0;
        }

        count++;
        map.put(name, count);

        System.out.printf("%s님의 %d번째 방문입니다.\n", name, count);
    }

    public static void main(String[] args) {
        Counter1 counter = new Counter1();
        counter.execute();
    }
}
