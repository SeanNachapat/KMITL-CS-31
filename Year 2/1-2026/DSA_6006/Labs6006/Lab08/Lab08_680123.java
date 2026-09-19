import java.util.Arrays;

import pack.*;

public class Lab08_680123 {
    // int[] arr =
    // {42,17,-5,88,23,91,-12,65,7,30,55,-9,2,48,76,1,-22,99,14,61,37,83,-18,50,29,72,6,40,-3,95,11,68};
    static void task_1() {
        int[] arr = { 42, 17, -5, 88, 23, 91, -12, 65, 7, 30, 55, -9, 2, 48, 76, 1, -22, 99, 14, 61, 37, 83, -18, 50,
                29, 72, 6, 40, 11, 68 }; // -3, 95
        MyMergeSort_680123 sol = new MyMergeSort_680123();
        sol.mSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void task_2() {
        int[] arr = { 42, 17, -5, 88, 23, 91, -12, 65, 7, 30, 55, -9, 2, 48, 76, 1, -22, 99, 14, 61, 37, 83, -18, 50,
                29, 72, 6, 40, 11, 68 }; // -3, 95
        MyQuickSort_680123 sol = new MyQuickSort_680123();
        sol.qSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void dutch_national_flag(int[] arr) {
        int left_value = arr[0]; // min
        int right_value = arr[0]; // max
        for (int i = 1; i < arr.length; i++) {
            left_value = Math.min(left_value, arr[i]);
            right_value = Math.max(right_value, arr[i]);
        }
        int left = 0, mid = 0, right = arr.length - 1;
        int tmp;
        while (mid <= right) {
            if (arr[mid] == left_value) {
                tmp = arr[left];
                arr[left] = arr[mid];
                arr[mid] = tmp;
                left++;
                mid++;
            } else if (arr[mid] == right_value) {
                tmp = arr[right];
                arr[right] = arr[mid];
                arr[mid] = tmp;
                right--;
            } else {
                mid++;
            }
        }
    }

    static void task_3() {
        // int[] arr = {1,0,2,2,0,0,1,2,2,1,1,2,1,0,2};

        // R B W W B B R W W R R W R B W
        int[] arr = { -1, 0, -2, -2, 0, 0, -1, -2, -2, -1, -1, -2, -1, 0, -2 };
        dutch_national_flag(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int k_th_min_element(int[] arr, int k) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max - min + 1];

        for (int x : arr) {
            count[x - min]++;
        }

        int seen = 0;
        for (int i = 0; i < count.length; i++) {
            seen += count[i];
            if (seen >= k) {
                return i + min;
            }
        }

        return -1; // k out of range
    }

    static void task_4() {
        int[] arr = { -1, 0, -2, -2, 0, 0, -1, -2, -2, -1, -1, -2, -1, 0, -2 };
        System.out.println(k_th_min_element(arr, 2));
    }

    public static void main(String[] args) {
        task_1();
        task_2();
        task_3();
        task_4();
    }
}
