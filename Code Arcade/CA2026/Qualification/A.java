import java.util.*;
import java.io.*;
import java.math.*;

//UNSOLVED

public class A {
    static FastReader sc = new FastReader();

    static class Job {
        public int value;
        public int day;
        public Job(int value, int day) {
            this.value = value;
            this.day = day;
        }
        @Override
        public String toString() {
            return "" + value + " " + day;
        }
    }
    public static void main(String[] args) {
        int n = sc.nextInt();
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int day = sc.nextInt();
            jobs.add(new Job(value, day));
        }
        Comparator<Job> jobComparator = (j1, j2) -> {
            return j1.day - j2.day;
        };
        Collections.sort(jobs, jobComparator);
        selectJob(jobs, 0);
        System.out.println(maxValue);
    }

    public static int maxValue = 0;
    public static ArrayList<ArrayList<Job>> cache = new ArrayList<>();
    public static void selectJob(ArrayList<Job> jobs, int i) {
        if (i >= jobs.size() || cache.contains(jobs)) return;
        cache.add((ArrayList<Job>) jobs.clone());
        int d = 1;
        int res = 0;
        int j = 0;
        while (j < jobs.size()) {
            if (jobs.get(j).day >= d) {
                res += jobs.get(j).value;
                d += 1;
            }
            j++;
        }
        if (maxValue < res) {
            maxValue = res;
        }
        selectJob((ArrayList<Job>)jobs.clone(), i + 1);
        ArrayList<Job> newJob = (ArrayList<Job>)jobs.clone();
        newJob.remove(i);
        selectJob(newJob, i);
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
