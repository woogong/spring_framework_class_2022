package spring.study.framework;

import java.util.Scanner;

public class SayHello1 extends MyFramework1 {
    public SayHello1() {
        super();
    }

    @Override
    protected void doJob(String name) {
        System.out.printf("안녕하세요. %s님.\n", name);
    }

    public static void main(String[] args) {
        SayHello1 sayHello = new SayHello1();
        sayHello.execute();
    }
}
