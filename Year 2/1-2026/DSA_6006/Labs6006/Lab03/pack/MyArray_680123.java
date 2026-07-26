package pack;

public class MyArray_680123 extends MyArrayBasic_680123 {

    public MyArray_680123(int capacity) {
        MAX_SIZE = capacity > 0 ? capacity : 1;
        data = new int[MAX_SIZE];
    }

    public MyArray_680123() {
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void expandByK(int k) {
        MAX_SIZE = MAX_SIZE * k;
        int[] tmp = new int[MAX_SIZE];
        for (int i = 0; i < data.length; i++) {
            tmp[i] = data[i];
        }
        data = tmp;
    }

    private void expandByK() {
        expandByK(2);
    }

    public void insert(int d) {
        if (isFull()) {
            expandByK();
        }
        int index = 0;
        if (isEmpty()) {
            data[index] = d;
            size++;
        } else {
            for (int i = 0; i < data.length; i++) {
                if (data[i + 1] > d) {
                    index = i + 1;
                    break;
                }
            }
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = d;
            size++;
        }
    }

    public int binarySearch(int target) {
        int low = 0, high = size - 1, m;
        while (low <= high) {
            m = low + (high - low) / 2;
            if (target == data[m])
                return m;
            else if (target < data[m])
                high = m - 1;
            else
                low = m + 1;
        }
        return (-(low) - 1);
    }

    @Override
    public int add(int d) {
        if (isFull()) {
            expandByK();
        }
        data[size] = d;
        size++;
        return size;
    }

    public void insert_unordered(int index, int d) {
        if (isFull()) {
            expandByK();
        }
        if (size <= index) {
            data[index] = d;
            size++;
        } else {
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = d;
            size++;
        }
    }

    public void delete(int index) {
        if (!isEmpty()) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;

        }
    }
}
