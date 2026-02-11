import java.util.ArrayList;

public class Set {
    ArrayList<Integer> set = new ArrayList<>();

    public Set() {
    }

    public void add(int value) {
        if (!set.contains(value)) {
            set.add(value);
        }
    }

    public void remove(int value) {
        set.remove(value);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public ArrayList<Integer> getElements() {
        return set;
    }
}

