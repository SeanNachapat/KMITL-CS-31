package pack;

import java.util.ArrayList;

public class MyStack_680123<T> {
    private ArrayList<T> items = new ArrayList<T>();

    public void push(T data) {
        items.add(data);
    }

    public T pop() {
        return items.remove(items.size() - 1);
    }

    public T peek() {
        return items.get(items.size() - 1);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public String toString() {
        String result = "";
        for (int i = items.size() - 1; i >= 0; i--) {
            result += items.get(i) + "\n";
        }
        return result;
    }
}