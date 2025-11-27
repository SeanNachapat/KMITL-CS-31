import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(fibo(13));
        System.out.println("-----------------");
        System.out.println(factorial(3));
        System.out.println("-----------------");
        System.out.println(pow(5, 3));
        System.out.println("-----------------");
        int[] num = { 10, 10, 10, 10, 10, 10 };
        System.out.println(Arrays.toString(num));
        System.out.println(sumArr(num));
        System.out.println("-----------------");
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(totalEven(arr, 0));
    }

    static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int pow(int n, int p) {
        if (p <= 1) {
            return n;
        }
        return n * pow(n, p - 1);
    }

    static int sumArr(int[] arr) {
        return sumRecursion(arr, 0);
    }

    static int sumRecursion(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sumRecursion(arr, index + 1);
    }

    static int totalEven(int[] arr, int i) {
        // base case
        if (i > arr.length - 1)
            return 0;

        if (arr[i] % 2 == 0)
            return arr[i] + totalEven(arr, i + 1);
        return totalEven(arr, i + 1);
    }

}