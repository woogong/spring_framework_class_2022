package spring.study.framework;

public class SayHello2 implements Doer {
    @Override
    public void doJob(String name) {
        System.out.printf("안녕하세요. %s님.\n", name);
    }

    public static void main(String[] args) {
        SayHello2 sayHello = new SayHello2();
        MyFramework2 myFramework = new MyFramework2();
        myFramework.execute(sayHello);
    }
}
