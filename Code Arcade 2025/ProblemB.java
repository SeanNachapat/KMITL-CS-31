import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int x = scr.nextInt(); // Distance to destination
        int y = scr.nextInt(); // Starting fuel
        int n = scr.nextInt(); // Amount of gas station
        int count = 0;
        int[][] pump = new int[n][2];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                pump[i][j] = scr.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            sorted[i] = pump[i][1];
        }

        Arrays.sort(sorted);

        while (y < x) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (sorted[i] == pump[j][2]) {

                    }
                }
            }
        }
        System.out.println(count);
        scr.close();
    }
}
