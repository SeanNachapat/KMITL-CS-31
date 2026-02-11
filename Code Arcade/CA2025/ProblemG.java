import java.util.Scanner; //SUBMITTED

public class ProblemG {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int T = scr.nextInt();
        int[] abc = new int[4];

        for (int i = 0; i < T; i++) {
            int sum = 0;
            int counter = 0;
            for (int j = 0; j < abc.length; j++) {
                abc[j] = scr.nextInt();
            }
            while (sum <= abc[0]) {
                for (int j = 1; j < abc.length; j++) {
                    if (sum < abc[0]) {
                        sum += abc[j];
                        counter++;
                    } else if (sum == abc[0]) {
                        sum += abc[j];
                    }
                }
            }
            System.out.println(counter);
        }
        scr.close();
    }
}
