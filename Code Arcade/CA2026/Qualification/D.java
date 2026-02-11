import java.util.*;
import java.io.*;
import java.math.*;

public class D {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        String a = sc.next();
        String b = sc.next();
        BigInteger n1 = new BigInteger(a);
        BigInteger n2 = new BigInteger(b);
        BigInteger ans = n1.modPow(n2, new BigInteger("1000"));
        String str = ans.toString();
        while (str.length() < 3) {
            str = "0" + str;
        }
        System.out.println(str);
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
