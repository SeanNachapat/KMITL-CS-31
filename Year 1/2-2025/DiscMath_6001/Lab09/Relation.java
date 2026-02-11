import java.util.ArrayList;

public class Relation {
    private Set set;
    private ArrayList<Pair> pairs;

    public Relation(Set set) {
        this.set = set;
        this.pairs = new ArrayList<>();
    }

    public void addPair(int a, int b) {
        pairs.add(new Pair(a, b));
    }

    public boolean isReflexive() {
        ArrayList<Integer> elements = set.getElements();
        for (Integer element : elements) {
            boolean found = false;
            for (Pair pair : pairs) {
                if (pair.x == element && pair.y == element) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetric() {
        for (Pair pair : pairs) {
            boolean foundReverse = false;
            for (Pair other : pairs) {
                if (other.x == pair.y && other.y == pair.x) {
                    foundReverse = true;
                    break;
                }
            }
            if (!foundReverse) {
                return false;
            }
        }
        return true;
    }

    public boolean isTransitive() {
        for (Pair p1 : pairs) {
            for (Pair p2 : pairs) {
                if (p1.y == p2.x) {
                    boolean foundTransitive = false;
                    for (Pair p3 : pairs) {
                        if (p3.x == p1.x && p3.y == p2.y) {
                            foundTransitive = true;
                            break;
                        }
                    }
                    if (!foundTransitive) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void checkAll() {
        System.out.println(pairs.toString());
        System.out.println("Reflexive: " + isReflexive());
        System.out.println("Symmetric: " + isSymmetric());
        System.out.println("Transitive: " + isTransitive());
    }

    private class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}

