package spring.study.framework;

import java.util.Scanner;

public abstract class MyFramework1 {
    protected Scanner scanner;

    public MyFramework1() {
        scanner = new Scanner(System.in);
    }

    public void execute() {
        String name = null;

        while (true) {
            name = inputName();
            if ("quit".equals(name)) {
                break;
            }

            doJob(name);
        }
    }

    protected abstract void doJob(String name);

    protected String inputName() {
        System.out.print("이름 : ");
        return scanner.nextLine();
    }
}

