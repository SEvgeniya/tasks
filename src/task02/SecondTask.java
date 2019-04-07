package task02;

public class SecondTask {

    public static void main(String[] args) {
        SecondTask secondTask = new SecondTask();
        secondTask.getResult(3, 5);
        System.out.println("-----------------------------------");
        secondTask.getResult(5, 3);
        secondTask.getResult(0, 0);
    }

    private Integer getFactorial(int x) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 1;
        }
        return x * getFactorial(x - 1);
    }
    public void getResult(int m, int r) {
        if (r <= m) {
            int a = getFactorial(m);
            int b = getFactorial(r);
            int c = getFactorial(m - r);

            System.out.println(a / (b * c));
        } else System.out.println("Incorrect data are entered");
    }
}
