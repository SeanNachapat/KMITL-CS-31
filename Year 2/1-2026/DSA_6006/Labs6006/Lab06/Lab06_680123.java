import java.util.Iterator;
import pack.MyQueue_680123;

public class Lab06_680123 {
    static void demoQueueIterator() {
        MyQueue_680123<String> queue = new MyQueue_680123<>();
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cantaloupe");
        System.out.print("standard for each: ");
        for (var item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("demo iterator");
        Iterator<String> iter = queue.iterator();
        char ch = 'n';
        while (iter.hasNext()) {
            String item = iter.next();
            if (item.indexOf(ch) != -1) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

    static void demoShuntingAndRPN() {
        String inFix = "( 4 + 2 ) / 3 * ( 8 - 5 )";
        String postFix = MyShuntingYard_680123.infixToPostfix(inFix);
        System.out.println("postFix= " + postFix);
        double ans = MyRPN_680123.computeRPN(postFix);
        System.out.println(ans);
    }

    static class MaxArea {
        public int maxLandArea(int[][] grid) {
            int max = 0;
            int rows = grid.length;
            int cols = grid[0].length;
            boolean[][] visited = new boolean[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1 && !visited[r][c]) {
                        int area = bfs(grid, visited, r, c);
                        max = Math.max(max, area);
                    }
                }
            }
            return max;
        }

        private int bfs(int[][] grid, boolean[][] visited, int startR, int startC) {
            int area = 0;
            MyQueue_680123<int[]> queue = new MyQueue_680123<>();

            visited[startR][startC] = true;
            queue.enqueue(new int[] { startR, startC });

            int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

            while (!queue.isEmpty()) {
                int[] curr = queue.dequeue();
                int r = curr[0];
                int c = curr[1];
                area++;

                for (int[] dir : dirs) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    if (isValid(grid, visited, nextR, nextC)) {
                        visited[nextR][nextC] = true;
                        queue.enqueue(new int[] { nextR, nextC });
                    }
                }
            }
            return area;
        }

        private boolean isValid(int[][] grid, boolean[][] visited, int r, int c) {
            return r >= 0 && r < grid.length &&
                    c >= 0 && c < grid[0].length &&
                    grid[r][c] == 1 && !visited[r][c];
        }
    }

    static void demoLargestIsland() {
        int[][] grid = {
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 },
                { 0, 0, 1, 1 },
                { 1, 1, 0, 0 }
        };
        MaxArea s = new MaxArea();
        int result = s.maxLandArea(grid);
        System.out.println("Largest land area: " + result);
    }

    public static void main(String[] args) {
        demoQueueIterator();
        demoShuntingAndRPN();
        demoLargestIsland();
    }
}
