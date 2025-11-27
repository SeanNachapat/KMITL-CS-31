import java.util.Scanner;

public class Lab03_Q1_2_68050123 {
    public static void main(String[] args) {

        int counter = 0;

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        while (x != 0) {
            x /= 10;
            counter++;
        }
        System.out.println(counter);
        scanner.close();
    }
}
