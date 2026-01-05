public class gcd {
    public static void main(String[] args) {
        System.out.println(GCD(1079, 52));
    }

    public static int GCD(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        System.out.println("\n--- Division Algorithm (a = bq + r) ---");

        while (b != 0) {
            int q = a / b;
            int r = a % b;

            System.out.println(a + " = " + b + " * " + q + " + " + r);
            a = b;
            b = r;
        }

        return a;
    }
}
