public class ProFun08_Q3_680123 {
    static boolean q3_common_element(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return true;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return true;
    }
}
