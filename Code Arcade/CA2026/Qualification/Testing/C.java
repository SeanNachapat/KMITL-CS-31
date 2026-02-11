package Testing;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int k = scr.nextInt();
        String m;
        int c = 0;
        int x;
        while (true) {
            m = scr.next();
            x = scr.nextInt();
            if (m.equals("?")) {
                if (x > k) {
                    System.out.println("<");
                } else if (x < k) {
                    System.out.println(">");
                } else {
                    System.out.println("=");
                }
            } else if (m.equals("!")) {
                if (x == k) {
                    break;
                } else {
                    System.out.println("WRONG-ANSWER");
                }
            }

            if (c == 30) {
                break;
            }
            c++;
            System.out.flush();
        }
        scr.close();
    }
}
