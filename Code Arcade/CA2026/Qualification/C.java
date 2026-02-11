import java.util.*;
import java.io.*;
import java.math.*;

public class C {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        int n,k;
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            k = sc.nextInt();
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> lis = new ArrayList<>(cnt.entrySet());
            lis.sort(Map.Entry.comparingByValue());
            lis = lis.reversed();
            System.out.println(lis.get(k - 1).getKey());           
        }
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
