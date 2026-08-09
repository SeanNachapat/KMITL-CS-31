package pack;

import java.util.ArrayList;
import java.util.Iterator;

public class MyQueue_680123<T> implements Iterable<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void enqueue(T data) {
        items.add(data);
    }

    public T dequeue() {
        if (!isEmpty()) {
            T result = items.remove(0);
            return result;
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return items.get(0);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Iterator<T> iterator() {
        return items.iterator();
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < items.size(); i++) {
            result += items.get(i) + " ";
        }
        return result;
    }
}