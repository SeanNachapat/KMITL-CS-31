package Testing;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int k = scr.nextInt();
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        int[] s = new int[n];
        for (int j = 0; j < n; j++) {
            a1[j] = scr.nextInt();
            a2[j] = scr.nextInt();
        }
        for (int i = 0; i < n; i++) {
            s[i] = a1[i] + a2[i];
        }

        Arrays.sort(s);
        System.out.println(s[k - 1]);

        scr.close();
    }
}
