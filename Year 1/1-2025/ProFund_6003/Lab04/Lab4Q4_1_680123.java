import java.util.Scanner;

public class Lab4Q4_1_680123 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int num = 2;
        int count = 0;
        int k = scr.nextInt();
        int[] perfectNum = new int[k];

        while (count < k) {
            int sum = 0;
            for (int j = 1; j <= num / 2; j++) {
                if (num % j == 0) {
                    sum += j;
                }
            }
            if (sum == num) {
                // System.out.println(sum);
                perfectNum[count] = sum;
                count++;
            }
            num++;
        }

        for (int i = 0; i < perfectNum.length; i++) {
            System.out.println(perfectNum[i]);
        }

        scr.close();
    }
}
