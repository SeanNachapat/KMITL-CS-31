import java.util.Arrays;

public class Lab09 {
    public static void main(String[] args) {
        int[][] intArr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] teamArr = { { 22, 88 }, { 11, 99 }, { 33, 77 } };
        System.out.println(right_diag_sum(intArr));
        System.out.println(Arrays.toString(max_sum_row(intArr)));
        System.out.println(Arrays.toString(retrieve_main_diagonal(intArr)));
        System.out.println(Arrays.deepToString(transpose(intArr)));
        System.out.println(Arrays.deepToString(by_point(teamArr)));
    }

    /* q1 */ static int right_diag_sum(int[][] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i][input.length - 1 - i];
        }
        return sum;
    }

    /* q2 */ static int[] max_sum_row(int[][] input) {
        int maxRow = 0;
        int currMax = 0;
        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            for (int j = 0; j < input[i].length; j++) {
                sum += input[i][j];
            }
            if (sum > currMax) {
                currMax = sum;
                maxRow = i;
            }
        }
        int[] copy = new int[input[0].length];
        for (int i = 0; i < input[0].length; i++) {
            copy[i] = input[maxRow][i];
        }
        return copy;
    }

    /* q3 */ static int[] retrieve_main_diagonal(int[][] input) {
        int[] diagonal = new int[input.length];
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[i] = input[i][i];
        }
        return diagonal;
    }

    /* q4 */ static int[][] transpose(int[][] mat) {
        int[][] transpose = new int[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                transpose[j][i] = mat[i][j];
            }
        }
        return transpose;
    }

    /* q5 */ static int[][] by_point(int[][] raw_score) {
        for (int i = 1; i < raw_score.length; i++) {
            int curr = raw_score[i][1];
            int rawCurr[] = raw_score[i];
            int j = i - 1;
            while (j >= 0 && curr > raw_score[j][1]) {
                raw_score[j + 1] = raw_score[j];
                j--;
            }
            raw_score[j + 1] = rawCurr;
        }
        // { 22, 88 }
        // { 11, 99 }
        // { 33, 77 }
        return raw_score;
    }

}
