import java.util.Scanner;

public class Lab4Q3_680123 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int parkHour = scr.nextInt();
        int remainHour = parkHour;
        int pay = 0;

        if (parkHour > 24) { // 24++ Hours
            pay = (parkHour / 24) * 24;
            remainHour -= (parkHour / 24) * 24;
        }
        if (remainHour >= 18 && remainHour <= 24) { // 18 - 24 Hours
            pay += 24;
        } else if (remainHour >= 4 && remainHour < 18) { // 4 - 18 Hours
            pay += 10 + (remainHour - 4);
        } else if (remainHour >= 2 && remainHour < 4) { // 2 - 4 Hours
            pay += 4 + 3 * (remainHour - 2);
        } else { // 0 - 2 Hours
            pay += 4;
        }

        System.out.printf("parking for %s hrs, pay %s baht.", parkHour, pay);
        scr.close();
    }

}
