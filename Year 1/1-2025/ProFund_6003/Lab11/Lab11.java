import java.util.Arrays;

public class Lab11 {
    public static void main(String[] args) {
        int[] leap = { 1, 10, 8 }; // Rabit Monkey Frog distance per step
        int dist = 100;
        int[][] rewards = { { 10, 1 }, { 16, 50 }, { 80, 10 }, { 100, 20 } };
        int[] track = new int[dist + 1];
        for (int i = 0; i < rewards.length; i++) {
            track[rewards[i][0]] = rewards[i][1];
        }
        // Ouput: Rabbit 81
        q2_toi0_68_02_024(leap, track, dist);

        ///-----------------------------------------------------------------------------------------///

        int[][] map = {
                { 0, 0, 9, 0, 0, 9, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 9, 9, 9, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 9, 9, 9, 0, 9, 0, 9, 9, 9, 0, 0 },
                { 0, 9, 0, 0, 0, 9, 0, 0, 0, 9, 0, 0 },
                { 0, 9, 0, 0, 0, 9, 9, 9, 0, 9, 0, 0 },
                { 0, 9, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0 },
                { 0, 9, 0, 0, 0, 0, 9, 9, 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0 },
        };

        int row = 0;

        q3_markMap(map);

        for (row = 0; row < map.length; row++) {
            System.out.println(Arrays.toString(map[row]) + "\t" + Arrays.toString(map[row]));
        }

        ///-----------------------------------------------------------------------------------------///

        int[][] tickets = {
                { 8, 15, 8, 25, 0 },
                { 8, 15, 10, 25, 1 },
                { 8, 15, 10, 25, 0 },
                { 8, 15, 12, 10, 1 },
                { 8, 15, 12, 10, 0 },
                { 8, 15, 9, 5, 1 } };
        System.out.println();
        for (int[] ticket : tickets) {
            String time = "in " + ticket[0] + ":" + ticket[1] + " out " +
                    ticket[2] + ":" + ticket[3] + ", " + (ticket[4] == 1 ? "coupon" : "none");
            System.out.print(time);
            System.out.println(" " + parkingFee_v2(ticket[0], ticket[1], ticket[2],
                    ticket[3], ticket[4] == 1) + "\t");
        }
    }

    static void q2_toi0_68_02_024(int[] leap_distances, int[] track, int dist) {
        String[] player = { "Rabbit", "Monkey", "Frog" };
        int maxScore = 0;
        int maxIndex = 0;
        for (int i = 0; i < leap_distances.length; i++) {
            int curr = 0;
            for (int j = 0; j < track.length; j += leap_distances[i]) {
                curr += track[j];
            }
            if (curr > maxScore) {
                maxIndex = i;
                maxScore = curr;
            }
        }
        System.out.println(player[maxIndex] + " " + maxScore);
    }

    static int[][] q3_markMap(int[][] bMap) {
        for (int i = 0; i < bMap.length; i++) {
            for (int j = 0; j < bMap[0].length; j++) {
                if (bMap[i][j] != 9) {
                    bMap[i][j] = 0;
                    if (j - 1 >= 0 && bMap[i][j - 1] == 9) { // left
                        bMap[i][j] += 1;
                    }
                    if (j + 1 < bMap[0].length && bMap[i][j + 1] == 9) { // right
                        bMap[i][j] += 1;
                    }
                    if (i - 1 >= 0 && j - 1 >= 0 && bMap[i - 1][j - 1] == 9) { // top-left
                        bMap[i][j] += 1;
                    }
                    if (i - 1 >= 0 && bMap[i - 1][j] == 9) { // top
                        bMap[i][j] += 1;
                    }
                    if (i - 1 >= 0 && j + 1 < bMap[0].length && bMap[i - 1][j + 1] == 9) { // top-right
                        bMap[i][j] += 1;
                    }
                    if (i + 1 < bMap.length && j - 1 >= 0 && bMap[i + 1][j - 1] == 9) { // bottom-left
                        bMap[i][j] += 1;
                    }
                    if (i + 1 < bMap.length && bMap[i + 1][j] == 9) { // bottom
                        bMap[i][j] += 1;
                    }
                    if (i + 1 < bMap.length && j + 1 < bMap[0].length && bMap[i + 1][j + 1] == 9) { // bottom-right
                        bMap[i][j] += 1;
                    }
                }
            }

        }
        return bMap;
    }

    static int parkingFee_v2(int hrIn, int minIn, int hrOut, int minOut, boolean hasCoupon) {
        int fee = 0;
        int hr = hrOut - hrIn;
        int min = minOut - minIn;
        if (min < 0) {
            min += 60;
            hr--;
        }
        min += hr * 60;
        if (hasCoupon) {
            if (min < 60) {
                fee = 0;
            } else if (min < 3 * 60) {
                fee = 20 * (int) Math.ceil((double) (min - 60) / 30);
            } else {
                fee = 80 + 30 * (int) Math.ceil((double) (min - 180) / 30);
            }
        } else {
            if (min < 15) {
                fee = 0;
            } else if (min < 3 * 30) {
                fee = 20 * (int) Math.ceil((double) (min - 15) / 30);
            } else if (min < 2 * 60) {
                fee = 80;
            } else {
                fee = 80 + 30 * (int) Math.ceil((double) (min - 120) / 30);
            }

        }
        return fee;
    }
}