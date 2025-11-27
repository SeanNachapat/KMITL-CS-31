import java.util.Scanner;

public class Lab4Q4_2_680123 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int num = scr.nextInt();
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum == 9) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        scr.close();
    }
}
