package Lab01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab01_680123 {
    static class StudentScoreBook {
        private HashMap<String, Integer> scores = new HashMap<String, Integer>();

        void addScore(String studentId, int score) {
            scores.put(studentId, score);
        }

        boolean updateScore(String studentId, int score) {
            if (scores.containsKey(studentId)) {
                scores.put(studentId, score);
                return true;
            }
            return false;
        }

        Integer findScore(String studentId) {
            return scores.get(studentId);
        }

        void printAll() {
            TreeMap<String, Integer> sortedScores = new TreeMap<>(scores);
            for (Map.Entry<String, Integer> entry : sortedScores.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    static Set<String> findDuplicateNames(List<String> names) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String name : names) {
            if (!seen.add(name)) {
                duplicates.add(name);
            }
        }
        return duplicates;
    }

    static class Patient {
        private final String name;
        private final int priority;
        private final int arrivalNo;

        Patient(String name, int priority, int arrivalNo) {
            this.name = name;
            this.priority = priority;
            this.arrivalNo = arrivalNo;
        }

        @Override
        public String toString() {
            return name + "(priority=" + priority + ", arrival=" + arrivalNo + ")";
        }
    }

    static class EmergencyRoom {
        Queue<Patient> waiting = new PriorityQueue<>((p1, p2) -> {
            int cp = Integer.compare(p1.priority, p2.priority);
            if (cp != 0) {
                return cp;
            }
            return Integer.compare(p1.arrivalNo, p2.arrivalNo);
        });
        private int nextArrivalNo = 1;

        void addPatient(String name, int priority) {
            waiting.add(new Patient(name, priority, nextArrivalNo++));
        }

        Patient peekNextPatient() {
            return waiting.peek();
        }

        Patient callNextPatient() {
            return waiting.poll();
        }

        boolean isEmpty() {
            return waiting.isEmpty();
        }
    }

    static int[][] computeTableDirect(List<int[]> matches) {
        int maxTeamId = matches.stream()
                .flatMapToInt(m -> IntStream.of(m[0], m[1]))
                .max()
                .orElse(0);

        int[][] stats = new int[maxTeamId][5]; // [teamId, MP, GF, GA, Pts]
        for (int i = 0; i < maxTeamId; i++) {
            stats[i][0] = i + 1;
        }
        for (int[] match : matches) {
            stats[match[0] - 1][1]++;
            stats[match[1] - 1][1]++;
            stats[match[0] - 1][2] += match[2];
            stats[match[1] - 1][2] += match[3];
            stats[match[0] - 1][3] += match[3];
            stats[match[1] - 1][3] += match[2];
            if (match[2] > match[3]) {
                stats[match[0] - 1][4] += 3;
            } else if (match[2] == match[3]) {
                stats[match[0] - 1][4] += 1;
                stats[match[1] - 1][4] += 1;
            } else {
                stats[match[1] - 1][4] += 3;
            }
        }

        Comparator<int[]> tableOrder = (a, b) -> compareTableRows(a, b);
        Arrays.sort(stats, tableOrder);
        return stats;
    }

    static class TeamStat {
        private final int teamId;
        private int matchesPlayed;
        private int goalsFor;
        private int goalsAgainst;
        private int points;

        TeamStat(int teamId) {
            this.teamId = teamId;
        }

        void recordMatch(int scored, int conceded) {
            matchesPlayed++;
            goalsFor += scored;
            goalsAgainst += conceded;
            if (scored > conceded) {
                points += 3;
            } else if (scored == conceded) {
                points++;
            }
        }

        int teamId() {
            return teamId;
        }

        int goalsFor() {
            return goalsFor;
        }

        int goalDifference() {
            return goalsFor - goalsAgainst;
        }

        int points() {
            return points;
        }

        int[] toRow() {
            return new int[] { teamId, matchesPlayed, goalsFor, goalsAgainst, points };
        }
    }

    static int[][] computeSimpleStream(List<int[]> matches) {
        int maxTeamId = matches.stream()
                .flatMapToInt(m -> IntStream.of(m[0], m[1]))
                .max()
                .orElse(0);

        TeamStat[] stats = new TeamStat[maxTeamId + 1];

        for (int teamId = 1; teamId <= maxTeamId; teamId++) {
            stats[teamId] = new TeamStat(teamId);
        }

        for (int[] match : matches) {
            stats[match[0]].recordMatch(match[2], match[3]);
            stats[match[1]].recordMatch(match[3], match[2]);
        }

        return Arrays.stream(stats)
                .filter(Objects::nonNull) // Filter out teamId = 0
                .sorted(Comparator.comparingInt(TeamStat::points).reversed()
                        .thenComparing(Comparator.comparingInt(TeamStat::goalDifference).reversed())
                        .thenComparing(Comparator.comparingInt(TeamStat::goalsFor).reversed())
                        .thenComparingInt(TeamStat::teamId))
                .map(TeamStat::toRow)
                .toArray(int[][]::new);
    }

    static int[][] computeTableStream(List<int[]> matches) {
        return matches.stream()
                .flatMap(match -> {
                    TeamStat t1 = new TeamStat(match[0]);
                    t1.recordMatch(match[2], match[3]);
                    TeamStat t2 = new TeamStat(match[1]);
                    t2.recordMatch(match[3], match[2]);
                    return java.util.stream.Stream.of(t1, t2);
                })
                .collect(Collectors.toMap(
                        TeamStat::teamId,
                        stat -> stat,
                        (stat1, stat2) -> {
                            stat1.matchesPlayed += stat2.matchesPlayed;
                            stat1.goalsFor += stat2.goalsFor;
                            stat1.goalsAgainst += stat2.goalsAgainst;
                            stat1.points += stat2.points;
                            return stat1;
                        }
                ))
                .values()
                .stream()
                .sorted(Comparator.comparingInt(TeamStat::points).reversed()
                        .thenComparing(Comparator.comparingInt(TeamStat::goalDifference).reversed())
                        .thenComparing(Comparator.comparingInt(TeamStat::goalsFor).reversed())
                        .thenComparingInt(TeamStat::teamId))
                .map(TeamStat::toRow)
                .toArray(int[][]::new);
    }

    static int compareTableRows(int[] a, int[] b) {
        int byPoints = Integer.compare(b[4], a[4]);
        if (byPoints != 0) {
            return byPoints;
        }
        int byGoalDifference = Integer.compare((b[2] - b[3]), (a[2] - a[3]));
        if (byGoalDifference != 0) {
            return byGoalDifference;
        }
        int byGoalsFor = Integer.compare(b[2], a[2]);
        if (byGoalsFor != 0) {
            return byGoalsFor;
        }
        int byTeamId = Integer.compare(a[0], b[0]);
        if (byTeamId != 0) {
            return byTeamId;
        }
        return 0;
    }

    static void displayTable(int[][] table, Map<Integer, String> teamNames) {
        System.out.println("Team    MP  GF  GA  Pts");
        for (int[] row : table) {
            String name = teamNames.getOrDefault(row[0], "Team" + row[0]);
            System.out.printf("%-7s %2d %3d %3d %4d%n",
                    name, row[1], row[2], row[3], row[4]);
        }
    }

    static List<int[]> sampleMatches() {
        return Arrays.asList(
                new int[] { 1, 2, 1, 2 }, new int[] { 1, 3, 2, 0 },
                new int[] { 1, 4, 0, 0 }, new int[] { 1, 5, 0, 1 },
                new int[] { 1, 6, 1, 2 }, new int[] { 1, 7, 2, 2 },
                new int[] { 2, 3, 3, 2 }, new int[] { 2, 4, 0, 1 },
                new int[] { 2, 5, 3, 3 }, new int[] { 2, 6, 3, 0 },
                new int[] { 2, 7, 2, 0 }, new int[] { 3, 4, 1, 0 },
                new int[] { 3, 5, 1, 0 }, new int[] { 3, 6, 2, 3 },
                new int[] { 3, 7, 0, 0 }, new int[] { 4, 5, 3, 1 },
                new int[] { 4, 6, 0, 0 }, new int[] { 4, 7, 1, 2 },
                new int[] { 5, 6, 0, 0 }, new int[] { 5, 7, 1, 0 },
                new int[] { 6, 7, 1, 0 });
    }

    static Map<Integer, String> sampleTeamNames() {
        return Map.of(
                1, "phy", 2, "chem", 3, "bio", 4, "math",
                5, "stat", 6, "com", 7, "kdai");
    }

    static void partA_demo_scoreBook() {
        StudentScoreBook book = new StudentScoreBook();
        book.addScore("6601001", 72);
        book.addScore("6601002", 81);
        book.addScore("6601003", 64);
        book.updateScore("6601003", 70);
        System.out.println("score of 6601002 = " + book.findScore("6601002"));
        book.printAll();
    }

    static void partA_demo_duplicateNames() {
        List<String> names = Arrays.asList("Ann", "Ben", "Cindy", "Ann", "Dan", "Ben");
        System.out.println("duplicate names = " + findDuplicateNames(names));
    }

    static void partA_demo_emergencyRoom() {
        EmergencyRoom er = new EmergencyRoom();
        er.addPatient("Somchai", 3);
        er.addPatient("Mali", 1);
        er.addPatient("Kanda", 2);
        er.addPatient("Arthit", 1);
        System.out.println("next patient = " + er.peekNextPatient());
        while (!er.isEmpty()) {
            System.out.println("call " + er.callNextPatient());
        }
    }

    static void partB_demo_direct() {
        System.out.println("direct solution");
        displayTable(computeTableDirect(sampleMatches()), sampleTeamNames());
    }

    static void partB_demo_stream() {
        System.out.println("stream solution");
        displayTable(computeSimpleStream(sampleMatches()), sampleTeamNames());
        System.out.println("\nstream solution (pure stream)");
        displayTable(computeTableStream(sampleMatches()), sampleTeamNames());
    }

    public static void main(String[] args) {
        partA_demo_scoreBook();
        System.out.println();
        partA_demo_duplicateNames();
        System.out.println();
        partA_demo_emergencyRoom();
        System.out.println();
        partB_demo_direct();
        System.out.println();
        partB_demo_stream();
    }
}
// score of 6601002 = 81
// 6601001 -> 72
// 6601002 -> 81
// 6601003 -> 70

// duplicate names = [Ann, Ben]

// next patient = Mali(priority=1, arrival=2)
// call Mali(priority=1, arrival=2)
// call Arthit(priority=1, arrival=4)
// call Kanda(priority=2, arrival=3)
// call Somchai(priority=3, arrival=1)

// direct solution
// Team MP GF GA Pts
// chem 6 13 7 13
// com 6 6 6 11
// math 6 5 4 8
// stat 6 6 7 8
// bio 6 6 8 7
// phy 6 6 7 5
// kdai 6 4 7 5

// stream solution
// Team MP GF GA Pts
// chem 6 13 7 13
// com 6 6 6 11
// math 6 5 4 8
// stat 6 6 7 8
// bio 6 6 8 7
// phy 6 6 7 5
// kdai 6 4 7 5