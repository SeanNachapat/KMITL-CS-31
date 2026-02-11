import java.util.*;
import java.io.*;
import java.math.*;

public class G {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        String str1 = sc.next();
        String str2 = sc.next();
        if (str1.length() != str2.length()) {
            System.out.println("FALSE");
            return;
        }
        int len = str1.length();
        Map<Character, Integer> count1 = new TreeMap<>();
        Map<Character, Integer> count2 = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            count1.put(str1.charAt(i), count1.getOrDefault(str1.charAt(i), 0) + 1);
            count2.put(str2.charAt(i), count2.getOrDefault(str2.charAt(i), 0) + 1);
        }
        if (count1.equals(count2)) System.out.println("TRUE");
        else System.out.println("FALSE");
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
