package spring.study.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Counter {
    protected Scanner scanner;

    protected Map<String, Integer> map;

    public Counter() {
        scanner = new Scanner(System.in);
        map = new HashMap<>();
    }

    public void execute() {
        String name = null;

        while (true) {
            name = inputName();
            if ("quit".equals(name)) {
                break;
            }

            Integer count = map.get(name);
            if (count == null) {
                count = 0;
            }

            count++;
            map.put(name, count);

            System.out.printf("%s님의 %d번째 방문입니다.\n", name, count);
        }

        scanner.close();
    }

    protected String inputName() {
        System.out.print("이름 : ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Counter sayHello = new Counter();
        sayHello.execute();
    }
}
