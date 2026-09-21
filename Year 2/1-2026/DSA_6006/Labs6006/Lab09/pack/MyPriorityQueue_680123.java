package pack;

public class MyPriorityQueue_680123 implements MyQueueIntf {
    static final int MAX_SIZE = 6;
    MyMinHeap_680123 heap = new MyMinHeap_680123();

    @Override
    public void enqueue(int d) {
        if (isFull()) return;   // discard when full
        heap.insert(d);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) return -1;
        return heap.remove();
    }

    @Override
    public int front() {
        return heap.peek();
    }

    @Override
    public boolean isFull() {
        return heap.size == MAX_SIZE;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
