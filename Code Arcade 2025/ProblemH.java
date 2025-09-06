import java.util.Scanner;

public class ProblemH { // โรงแกะมหึมา
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt(); // Amount Of Sheep
        int x = scr.nextInt(); // Amount of Chosen Sheep
        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        long a = 0;
        long b = 1;
        for (int j = 2; j < n + 1; j++) {
            fib[j] = (a + b) % (long) (Math.pow(10, 9) + 7);
            a = b;
            b = fib[j];
        }
        for (int i = 0; i < x; i++) {
            System.out.println(fib[scr.nextInt()]);

        }

        scr.close();
    }

    // public static long fibo(int num) {
    // long fibo = 1;
    // long a = 0;
    // long b = 1;
    // for (int j = 0; j < num - 1; j++) {
    // fibo = (a + b) % (long) (Math.pow(10, 9) + 7);
    // a = b;
    // b = fibo;
    // }
    // return fibo;
    // }
}
