import java.util.Scanner;

public class Lab4Q2_680123 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int[] prices = new int[3];
        int price1 = scr.nextInt();
        int price2 = scr.nextInt();
        int price3 = scr.nextInt();
        prices[0] = price1;
        prices[1] = price2;
        prices[2] = price3;

        int total = price1 + price2 + price3;
        int minPrice = Math.min(price1, Math.min(price2, price3));
        int amountCharge = total - minPrice;

        System.out.println(amountCharge);

        scr.close();
    }
}