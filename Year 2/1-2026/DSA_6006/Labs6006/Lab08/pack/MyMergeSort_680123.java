package pack;

public class MyMergeSort_680123 {
    public void mSort(int[] nums) {
        int[] tmp = new int[nums.length];
        mSort(nums, tmp, 0, nums.length - 1);
    }

    private void mSort(int[] arr, int[] tmp, int low, int high) {
        if (low >= high)
            return;
        int mid = low + ((high - low) >> 1);
        mSort(arr, tmp, low, mid);
        mSort(arr, tmp, mid + 1, high);
        merge(arr, tmp, low, mid, high);
    }

    private void merge(int[] arr, int[] tmp, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tmp[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                arr[k] = tmp[j++];
            } else if (j > high || tmp[i] < tmp[j]) {
                arr[k] = tmp[i++];
            } else {
                arr[k] = tmp[j++];
            }
        }

    }
}
