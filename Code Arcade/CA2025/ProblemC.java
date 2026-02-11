import java.util.Scanner; //SUBMITTED
import java.util.Arrays;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int sum = 0;

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scr.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i += 2) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        System.out.println(sum);
        scr.close();
    }
}
