import java.util.Scanner; //DONE?

public class ProblemF {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int T = scr.nextInt(); // จำนวนเกม
        String result = "";

        int X[] = new int[2];
        int O[] = new int[2];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < X.length; j++) {
                X[j] = scr.nextInt();
            }
            for (int j = 0; j < O.length; j++) {
                O[j] = scr.nextInt();
            }
            if (X[0] * X[1] == 4 && Math.abs(X[0] - X[1]) == 1) {
                result = "YES";
            } else if (Math.abs(X[0] - X[1]) != 1 && X[0] * X[1] != 4 && O[0] * O[1] != 4) {
                result = "YES";
            } else if (Math.abs(X[0] - X[1]) == 1 && (O[0] - O[1]) == 1) {
                result = "YES";
            } else {
                result = "NO";
            }

            System.out.println(result);
        }

        scr.close();
    }
}
