import java.util.*;
import java.io.*;
import java.math.*;

public class B {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int l = sc.nextInt();
        int b5 = l / 5;
        for (; b5 >= 0; b5--) {
            int bLeft = l;
            bLeft -= (b5 * 5);
            int b4 =  bLeft / 4;
            for (; b4 >= 0; b4--) {
                bLeft -= (b4 * 4);
                int b3 = bLeft / 3;
                bLeft -= (b3 * 3);
                if (bLeft == 0) {
                    System.out.println(b5 + b4 + b3);
                    return;
                }
                bLeft += ((b4 * 4) + (b3 * 3));
            }
        }
        System.out.println(-1);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
