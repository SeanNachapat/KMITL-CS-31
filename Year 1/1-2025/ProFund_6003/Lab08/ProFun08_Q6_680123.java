import java.util.Arrays;
import java.util.Scanner;

public class ProFun08_Q6_680123 {
    static void q5_topK(int... data) {
        Scanner scr = new Scanner(System.in);
        int tmp;
        int input;
        int p = 0;
        Boolean isDone = false;
        int[] intArr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println(Arrays.toString(intArr));
        while (!isDone) {
            input = scr.nextInt();
            if (input <= 0) {
                isDone = true;
            } else if (input < intArr[9]) {
                System.out.println(Arrays.toString(intArr));
                continue;
            } else {
                intArr[p] = input;
                for (int i = p; i > 0; i--) {
                    if (intArr[i] > intArr[i - 1]) {
                        tmp = intArr[i];
                        intArr[i] = intArr[i - 1];
                        intArr[i - 1] = tmp;
                    }
                }
            }
            System.out.println(Arrays.toString(intArr));
            if (p < 9) {
                p++;
            } else {
                p = 9;
            }
        }

        scr.close();
    }

    public static void main(String[] args) {
        q5_topK();
    }
}
