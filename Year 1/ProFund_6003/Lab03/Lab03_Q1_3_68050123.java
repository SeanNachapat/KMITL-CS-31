import java.util.Scanner;

public class Lab03_Q1_3_68050123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rem;
        int result = 0;
        int x = scanner.nextInt();

        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        System.out.println(result);
        scanner.close();
    }
}
