import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 8, 3, 5, 1, 9 };
        System.out.println(Arrays.toString(sorted(arr)));
    }

    static int[] sorted(int[] arr) {
        int tmp, min;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
