import java.util.Scanner; //DONE

public class ProblemE {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt(); // จํานวนสไปโนซอรัส
        int a = scr.nextInt(); // พลงัโจมตีของคุณ
        int b = scr.nextInt(); // พลงัโจมตของคู่แข่ง
        int k = scr.nextInt(); // จํานวนครังที่เหลี่ยม
        int point = 0;

        int spino[] = new int[n];

        for (int i = 0; i < spino.length; i++) {
            spino[i] = scr.nextInt();
        }

        for (int i = 0; i < spino.length; i++) {
            while (spino[i] > 0) {
                // ตาคุณ
                spino[i] -= a;
                if (spino[i] <= 0) {
                    point++;

                } else if ((spino[i] <= b && k > spino[i] / b && k > 0) || (spino[i] <= a && k > 0)) {
                    k--;
                } else if (spino[i] > 0) {
                    // ตาคู่แข่ง
                    spino[i] -= b;
                }
            }
        }
        System.out.println(point);
        scr.close();
    }
}
