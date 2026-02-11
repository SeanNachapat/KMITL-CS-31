package Testing;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        String result = "";
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        for (int i = 0; i < n; i++) {
            result += (scr.nextInt() + scr.nextInt()) + "\n";
        }

        System.out.println(result);
        scr.close();
    }
}