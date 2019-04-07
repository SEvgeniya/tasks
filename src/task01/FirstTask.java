package task01;

import java.util.stream.IntStream;

public class FirstTask {

    public static void main(String[] args) {

        String[] num = new String[100];
        for (int i = 0; i < 100; i ++) {
            num[i] = String.valueOf(i+1);
        }

        IntStream.range(0, num.length).forEach(i -> {
            if (Integer.valueOf(num[i]) % 2 == 0 && Integer.valueOf(num[i]) % 7 == 0) {
                num[i] = "TwoSeven";
                return;
            }
            if (Integer.valueOf(num[i]) % 2 == 0) {
                num[i] = "Two";
                return;
            }
            if (Integer.valueOf(num[i]) % 7 == 0) {
                num[i] = "Seven";
            }
        });
        for (String s : num) {
            System.out.println(s);
        }
    }
}