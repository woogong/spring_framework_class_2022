package spring.study.framework;

import java.util.Random;
import java.util.Scanner;

public abstract class ArrayDevice {

    public void execute() {
        // 사용자에게 배열의 크기를 물어봅니다.
        int size = inputSize();

        // 배열을 만듭니다.
        int[] array = new int[size];

        // 배열에 난수를 이용해서 값을 채워 넣습니다.
        fillValues(array);

        // 최대값을 찾아서 출력합니다.
        doJob(array);
    }

    protected int inputSize() {
        System.out.print("배열의 크기 : ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();

        return size;
    }

    protected void fillValues(int[] array) {
        Random random = new Random();
        for (int i = 0 ; i < array.length ; i++) {
            array[i] = random.nextInt(10000);
        }
    }

    protected abstract void doJob(int[] array);

    /*
    protected void findMaxAndPrint(int[] array) {
        int max = 0;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }

        System.out.println("최대값 : " + max);
    }
     */

}
