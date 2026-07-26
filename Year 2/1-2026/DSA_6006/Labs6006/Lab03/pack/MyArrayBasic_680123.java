package pack;

public class MyArrayBasic_680123 {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic_680123() {
    }

    public MyArrayBasic_680123(int... a) {
        for (int i = 0; i < MAX_SIZE; i++) {
            data[i] = a[i];
            size++;
        }
    }

    public int add(int d) {
        try {
            data[size] = d;
            size++;
            return size;
        } catch (Exception e) {
            System.out.println(e);
            return MAX_SIZE;
        }
    }

    public void insert_unordered(int index, int d) {
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

    public int find(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size - 1; i++)
            sb.append(data[i] + ", ");
        if (size > 0)
            sb.append(data[size - 1]);
        sb.append("]");
        return sb.toString();
    }

    public int getAt(int idx) {
        return data[idx];
    }

    public void setAt(int d, int idx) {
        data[idx] = d;
    }
}
