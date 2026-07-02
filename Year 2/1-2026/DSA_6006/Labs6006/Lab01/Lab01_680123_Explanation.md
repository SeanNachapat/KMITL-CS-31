# Lab 01 Java Classes & Implementations Explanation
**Student ID:** 680123  
**Course:** DSA (Data Structures & Algorithms)

---

## Table of Contents
1. [Overview](#overview)
2. [Part A: Core Classes & Utilities](#part-a-core-classes--utilities)
   - [`StudentScoreBook`](#studentscorebook)
   - [`Patient` & `EmergencyRoom` (Priority Queue)](#patient--emergencyroom-priority-queue)
   - [`findDuplicateNames` Utility](#findduplicatenames-utility)
3. [Part B: Sports Tournament Table Computation](#part-b-sports-tournament-table-computation)
   - [`TeamStat`](#teamstat)
   - [`computeTableDirect` (Traditional Loop)](#computetabledirect-traditional-loop)
   - [`computeSimpleStream` (Stateful Stream - Debugged)](#computesimplestream-stateful-stream---debugged)
   - [`computeTableStream` (Pure Stream - Advanced)](#computetablestream-pure-stream---advanced)
4. [Comparison of Table Computation Methods](#comparison-of-table-computation-methods)

---

## Overview
This laboratory assignment demonstrates the use of core Java Collections framework (such as `HashMap`, `TreeMap`, `HashSet`, `PriorityQueue`, and `Streams`). It is split into two parts:
- **Part A:** Basic data structures (student database, duplicate detection, and emergency patient scheduling).
- **Part B:** Real-world data transformation (constructing and sorting a tournament table from a list of match results using three different programming paradigms).

---

## Part A: Core Classes & Utilities

### `StudentScoreBook`
`StudentScoreBook` is a class designed to store and query student exam scores. 

* **Data Structure:** Uses a `HashMap<String, Integer>` named `scores` for storing student IDs (keys) and scores (values). This provides $O(1)$ average-case complexity for insertions, updates, and lookups.
* **Key Methods:**
  * `addScore(String studentId, int score)`: Inserts a student and score into the map.
  * `updateScore(String studentId, int score)`: Updates a student's score if the student exists. Returns `true` if updated, `false` otherwise.
  * `findScore(String studentId)`: Looks up a score. Returns the score, or `null` if the student ID is not found.
  * `printAll()`: Instantiates a `TreeMap<String, Integer>` initialized with the `scores` map to sort keys alphabetically ($O(N \log N)$ complexity), then iterates through the entry set to print them.

---

### `Patient` & `EmergencyRoom` (Priority Queue)
These classes implement a triage scheduling system where patients are called based on urgency rather than simple arrival time.

#### 1. `Patient`
An immutable class representing a patient.
* **Fields:**
  * `name`: The patient's name.
  * `priority`: Urgency rank (lower value = higher urgency, e.g., `1` is more critical than `3`).
  * `arrivalNo`: Unique sequence number tracking when the patient arrived.

#### 2. `EmergencyRoom`
* **Data Structure:** Uses a `PriorityQueue<Patient>` ordered by a custom comparator to manage the queue.
* **Triage Algorithm (Comparator):**
  ```java
  (p1, p2) -> {
      int cp = Integer.compare(p1.priority, p2.priority);
      if (cp != 0) {
          return cp; // Primary sort: Lower priority value first
      }
      return Integer.compare(p1.arrivalNo, p2.arrivalNo); // Secondary sort (Tie-breaker): Earlier arrival first (FIFO)
  }
  ```
* **Key Methods:**
  * `addPatient(String name, int priority)`: Creates and queues a new patient, auto-incrementing `nextArrivalNo`.
  * `peekNextPatient()`: Inspects the highest-priority patient in $O(1)$ time.
  * `callNextPatient()`: Removes and returns the highest-priority patient in $O(\log N)$ time.

---

### `findDuplicateNames` Utility
A static method that takes a list of names and extracts all duplicate names.

* **Algorithm:** Uses two `HashSet` objects: `seen` and `duplicates`.
* **Complexity:** Runs in $O(N)$ time and $O(N)$ space.
```java
static Set<String> findDuplicateNames(List<String> names) {
    Set<String> seen = new HashSet<>();
    Set<String> duplicates = new HashSet<>();
    for (String name : names) {
        if (!seen.add(name)) { // add() returns false if elements already exist in Set
            duplicates.add(name);
        }
    }
    return duplicates;
}
```

---

## Part B: Sports Tournament Table Computation

### `TeamStat`
A class representing statistics for a specific team in a league tournament.
* **Fields:** `teamId`, `matchesPlayed`, `goalsFor` (GF), `goalsAgainst` (GA), and league `points` (Pts).
* **Win/Draw/Loss Logic:**
  * **Win:** 3 points (`scored > conceded`)
  * **Draw:** 1 point (`scored == conceded`)
  * **Loss:** 0 points (`scored < conceded`)
* **Methods:**
  * `recordMatch(int scored, int conceded)`: Updates the team's matches played, goals, and points.
  * `goalDifference()`: Helper calculating Goal Difference (GD = `goalsFor - goalsAgainst`).
  * `toRow()`: serializes the instance into a flat integer array: `[teamId, matchesPlayed, goalsFor, goalsAgainst, points]`.

---

### `computeTableDirect` (Traditional Loop)
This method constructs the league standings using standard arrays and loops.
1. Finds the maximum `teamId` to dimension the statistics array size.
2. Allocates a 2D array `int[][] stats` where each row represents a team's stats.
3. Loops through each match, updating goals, match count, and points manually for both home and away teams.
4. Sorts the 2D array using the custom comparator `compareTableRows`.

---

### `computeSimpleStream` (Stateful Stream - *Debugged*)
A hybrid solution combining iterative accumulation with stream-based sorting.

#### The Bug
In the original code:
1. An array `TeamStat[] stats` was instantiated but the match details were **never logged** (no `recordMatch` loop). All teams had `0` points and `0` goals.
2. The stream sorting comparator was sorting in **ascending** order of points, goal difference, and goals scored, resulting in the worst team rising to the top.

#### The Fix
1. Added a loop to record the results of all matches into the stats array:
   ```java
   for (int[] match : matches) {
       stats[match[0]].recordMatch(match[2], match[3]);
       stats[match[1]].recordMatch(match[3], match[2]);
   }
   ```
2. Corrected the comparator chain to sort descending using `.reversed()` for points, goal difference, and goals for:
   ```java
   .sorted(Comparator.comparingInt(TeamStat::points).reversed()
           .thenComparing(Comparator.comparingInt(TeamStat::goalDifference).reversed())
           .thenComparing(Comparator.comparingInt(TeamStat::goalsFor).reversed())
           .thenComparingInt(TeamStat::teamId))
   ```

---

### `computeTableStream` (Pure Stream - *Advanced*)
An elegant functional-style method implementing the entire pipeline without external side-effects or loop constructs.

1. **`flatMap`**: Converts each match `[teamA, teamB, goalsA, goalsB]` into two temporary `TeamStat` objects (one for each participant team).
2. **`collect(Collectors.toMap(...))`**: Groups and reduces the stats.
   * **Key:** `TeamStat::teamId`
   * **Value:** The `TeamStat` object itself.
   * **Merge Function:** Sums matches played, goals, and points if two `TeamStat` instances share the same `teamId`.
3. **`sorted(...)`**: Sorts the map's collection of merged values using the descending comparator chain.
4. **`map(TeamStat::toRow)`** and **`toArray(...)`**: Serializes the sorted statistics to the final `int[][]` array structure.

```java
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
```

---

## Comparison of Table Computation Methods

| Criteria | `computeTableDirect` | `computeSimpleStream` | `computeTableStream` |
| :--- | :--- | :--- | :--- |
| **Paradigm** | Imperative | Mixed (Imperative + Functional) | Pure Functional |
| **State Mutation** | Modifies local 2D array | Modifies local array of objects | Immutably transforms stream items |
| **Readability** | Verbose; uses low-level indices | Cleaner sorting, but relies on loops | Highly declarative and readable |
| **Complexity** | Time: $O(M + N \log N)$<br>Space: $O(N)$ | Time: $O(M + N \log N)$<br>Space: $O(N)$ | Time: $O(M + N \log N)$<br>Space: $O(M)$ (extra stream elements) |

*Where $M$ is the number of matches, and $N$ is the number of teams.*
