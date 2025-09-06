import java.util.Scanner; //SUBMITTED
import java.util.Arrays;

class ProblemA {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int k = scr.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] sum = new int[n];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = scr.nextInt();
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = scr.nextInt();
        }

        for (int i = 0; i < sum.length; i++) {
            sum[i] = arr1[i] + arr2[i];
        }

        Arrays.sort(sum);
        System.out.println(sum[n - k]);
        scr.close();
    }
}
