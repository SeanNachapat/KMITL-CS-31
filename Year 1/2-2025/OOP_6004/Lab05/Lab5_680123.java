import java.util.Arrays;

public class Lab5_680123 {
    static int[] data = { 28, 58, 8, 77, 48, 39 };
    static ArrayProcessor q1NumberOfEvenElement; // 4
    static ArrayProcessor q2IndexOfLargestEvenValue; // 1
    static ArrayProcessor myMedian; // custom definition...use (n/2)th element of sorted i.e. 48

    static void q1() {
        /* your code */
        q1NumberOfEvenElement = (arr) -> {
            int count = 0;
            for (int num : arr) {
                if (num % 2 == 0) {
                    count++;
                }
            }
            return count;
        };
        System.out.println("q1: " + q1NumberOfEvenElement.calculate(data));
    }

    static void q2() {
        /* your code */
        q2IndexOfLargestEvenValue = (arr) -> {
            int maxVal = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0 && arr[i] > maxVal) {
                    maxVal = arr[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        };
        System.out.println("q2: " + q2IndexOfLargestEvenValue.calculate(data));
    }

    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        /* your code */
        myMedian = (arr) -> arr[arr.length / 2];

        System.out.println(myMedian.calculate(tmp));
    }

    public static void main(String[] args) {
        q1();
        q2();
        oneline();
    }
}
