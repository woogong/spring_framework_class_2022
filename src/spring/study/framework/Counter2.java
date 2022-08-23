package spring.study.framework;

import java.util.HashMap;
import java.util.Map;

public class Counter2 implements Doer {
    protected Map<String, Integer> map;

    public Counter2() {
        this.map = new HashMap<>();
    }

    @Override
    public void doJob(String name) {
        Integer count = map.get(name);
        if (count == null) {
            count = 0;
        }

        count++;
        map.put(name, count);

        System.out.printf("%s님의 %d번째 방문입니다.\n", name, count);
    }

    public static void main(String[] args) {
        Counter2 counter = new Counter2();
        MyFramework2 myFramework = new MyFramework2();
        myFramework.execute(counter);
    }
}
