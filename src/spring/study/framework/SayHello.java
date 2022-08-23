package spring.study.framework;

import java.util.Scanner;

public class SayHello {
    protected Scanner scanner;

    public SayHello() {
        scanner = new Scanner(System.in);
    }

    public void execute() {
        String name = null;

        while (true) {
            name = inputName();
            if ("quit".equals(name)) {
                break;
            }

            System.out.printf("안녕하세요. %s님.\n", name);
        }

        scanner.close();
    }

    protected String inputName() {
        System.out.print("이름 : ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        SayHello sayHello = new SayHello();
        sayHello.execute();
    }
}
