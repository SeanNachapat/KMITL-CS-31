import java.util.ArrayList;

class lab10 {
    public static void main(String[] args) {
        int[] weight = { 2, 11, 333 };
        q3_combi_elements(weight);
    }

    static void q3_combi_elements(int[] weights, int idx, int wei, ArrayList<Integer> lis) {
        if (idx == weights.length) {
            System.out.println(lis + " = " + wei);
            return;
        }
        /* your code */
        lis.add(idx);
        q3_combi_elements(weights, idx + 1, wei + weights[idx], lis);
        lis.remove(lis.size() - 1);
        q3_combi_elements(weights, idx + 1, wei, lis);
    }

    static void q3_combi_elements(int[] weights) {
        q3_combi_elements(weights, 0, 0, new ArrayList<Integer>()); /* only lis for the program */
    }
}