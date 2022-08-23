package spring.study.framework;

import java.util.Scanner;

public class MyFramework2 {
    protected Scanner scanner;

    public MyFramework2() {
        scanner = new Scanner(System.in);
    }

    public void execute(Doer doer) {
        String name = null;

        while (true) {
            name = inputName();
            if ("quit".equals(name)) {
                break;
            }

            doer.doJob(name);
        }
    }

    protected String inputName() {
        System.out.print("이름 : ");
        return scanner.nextLine();
    }
}

