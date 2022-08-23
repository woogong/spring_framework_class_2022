package spring.study.framework;


public class FindMax extends ArrayDevice {

    protected void doJob(int[] array) {
        int max = 0;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }

        System.out.println("최대값 : " + max);
    }

    public static void main(String[] args) {
        FindMax findMax = new FindMax();
        findMax.execute();
    }
}
