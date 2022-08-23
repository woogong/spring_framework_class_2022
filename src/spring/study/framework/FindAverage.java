package spring.study.framework;


public class FindAverage extends ArrayDevice {

    protected void doJob(int[] array) {
        int total = 0;
        for (int value : array) {
            total += value;
        }

        double average = (double)total / (double)array.length;

        System.out.printf("평균값 : %.2f\n" + average);
    }

    public static void main(String[] args) {
        FindAverage findAverage = new FindAverage();
        findAverage.execute();
    }
}
