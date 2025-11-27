import java.util.Arrays;

public class ProFun08_Q4_680123 {
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
}
