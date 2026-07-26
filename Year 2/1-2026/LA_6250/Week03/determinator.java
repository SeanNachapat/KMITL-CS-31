public class determinator {
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }

    public static void demo1() {
        int[][] m1 = { { 5 } };
        System.out.println("Demo 1 (Matrix 1x1):");
        printMatrix(m1);
        System.out.println("Determinant: " + det(m1));
    }

    public static void demo2() {
        int[][] m2 = {
                { 1, 2 },
                { 3, 4 }
        };
        System.out.println("Demo 2 (Matrix 2x2):");
        printMatrix(m2);
        System.out.println("Determinant: " + det(m2));
    }

    public static void demo3() {
        int[][] m3 = {
                { 6, 1, 1 },
                { 4, -2, 5 },
                { 2, 8, 7 }
        };
        System.out.println("Demo 3 (Matrix 3x3):");
        printMatrix(m3);
        System.out.println("Determinant: " + det(m3));
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
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