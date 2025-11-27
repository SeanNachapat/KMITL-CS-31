import java.util.Arrays;

public class ProFun08_Q2_680123 {
    public static void main(String[] args) {

        int[] a = { 2, 3, 5, 7 };
        int[] b = { 4, 6, 7, 8 };

        System.out.println("----------");
        int[] q4_1 = { 2, 3, 5, 6, 0 };
        q4_1(q4_1, 4);

        System.out.println("----------");
        int[] q4_2 = { 2, 3, 5, 6, 0 };
        q4_2(q4_2, 7);

        System.out.println("----------");
        int[] q4_3 = { 2, 3, 5, 6, 8 };
        q4_3(q4_3, 9);

        System.out.println("----------");
        int[] sortSquare = { -4, -1, 0, 3, 10 };
        sortSquare(sortSquare);
    }

    static boolean q3_common_element(int[] a, int[] b) {

        return true;
    }

    static void q4_1(int[] nums, int d) {
        for (int i = 0; i < nums.length; i++) {
            if (d < nums[i]) {
                for (int j = nums.length - 1; j > i; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[i] = d;
                break;
            }
        }
        System.out.println(Arrays.toString(nums)); // [2,3,4,5,6]
    }

    static void q4_2(int[] nums, int d) {
        for (int i = 1; i < nums.length; i++) {
            if (d > nums[i - 1] && nums[i - 1] + 1 == d) {
                for (int j = nums.length - 1; j > i; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[i] = d;
                break;
            }
        }
        System.out.println(Arrays.toString(nums)); // [2,3,5,6,7]
    }

    static void q4_3(int[] nums, int d) {
        for (int i = 1; i < nums.length; i++) {
            if (d > nums[i - 1] && nums[i - 1] + 1 == d && nums[i] == 0) {
                for (int j = nums.length - 1; j > i; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[i] = d;
                break;
            }
        }
        System.out.println(Arrays.toString(nums)); // [2,3,5,6,8] // nothing change
    }

    static void sortSquare(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }

        System.out.println(Arrays.toString(result));
    }

    static void q5_topK(int... data) {

    }

}
