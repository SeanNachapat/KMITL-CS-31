import java.util.Scanner;

public class determinator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of rows : ");
        int row = sc.nextInt();
        System.out.print("Enter the Number of columns : ");
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        System.out.println("Enter the Elements of Matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("------- Matrix 1 -------");
        printMatrix(matrix);
        System.out.println("Determinant of the Matrix is : " + det(matrix));
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int val : row) {
                System.out.print(val);
                if (val != row[row.length - 1]) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static int det(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int det = 0;
        int sign = 1;
        for (int i = 0; i < n; i++) {
            int[][] submatrix = getSubmatrix(matrix, 0, i);
            det += sign * matrix[0][i] * det(submatrix);
            sign = -sign;
        }
        return det;
    }

    private static int[][] getSubmatrix(int[][] matrix, int excludeRow, int excludeCol) {
        int n = matrix.length;
        int[][] submatrix = new int[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == excludeRow) {
                continue;
            }
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludeCol) {
                    continue;
                }
                submatrix[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return submatrix;
    }
}