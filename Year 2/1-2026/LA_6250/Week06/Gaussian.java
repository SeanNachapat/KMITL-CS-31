import java.util.Scanner;

public class Gaussian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        double[][] a = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                a[i][j] = sc.nextDouble();
            }
        }
        System.out.println("\nInitial Augmented Matrix:");
        printMatrix(a);

        Gaussian(a);
        sc.close();
    }

    static void Gaussian(double[][] a) {
        int n = a.length;

        // Forward Elimination
        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(a[k][i]) > Math.abs(a[maxRow][i])) {
                    maxRow = k;
                }
            }

            double[] temp = a[i];
            a[i] = a[maxRow];
            a[maxRow] = temp;

            for (int j = i + 1; j < n; j++) {
                double factor = a[j][i] / a[i][i];
                for (int k = i; k <= n; k++) {
                    a[j][k] -= factor * a[i][k];
                }
            }
        }

        System.out.println("\nUpper Triangular Matrix after Elimination:");
        printMatrix(a);

        // Back Substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += a[i][j] * x[j];
            }
            x[i] = (a[i][n] - sum) / a[i][i];
        }
        System.out.println("\nSolution:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.4f\n", i + 1, x[i]);
        }
    }

    static void printMatrix(double[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == n) {
                    System.out.printf("| %8.4f", a[i][j]);
                } else {
                    System.out.printf("%8.4f ", a[i][j]);
                }
            }
            System.out.println();
        }
    }
}
