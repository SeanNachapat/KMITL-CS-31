import java.util.Arrays;

public class twoDArray {
    public static void main(String[] args) {
        int[][] num1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num1[0].length; j++) {
                System.out.print(num1[i][j]);
                System.out.printf("\t");
            }
            System.out.println();
        }

        int[][] num2 = new int[3][3];
        System.out.println(Arrays.deepToString(num2));
    }
}
