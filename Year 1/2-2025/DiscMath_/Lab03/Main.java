import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        System.out.println("--- Results ---");
        System.out.println("Binary: " + convertToBase(decimal, 2));
        System.out.println("Octal:  " + convertToBase(decimal, 8));
        System.out.println("Hex:    " + convertToBase(decimal, 16));
    }

    public static String convertToBase(int num, int base) {
        if (num == 0)
            return "0";

        String hexChars = "0123456789ABCDEF";

        String result = "";

        while (num > 0) {
            int remainder = num % base; 

            result = hexChars.charAt(remainder) + result;

            num /= base;
        }

        return result;
    }
}