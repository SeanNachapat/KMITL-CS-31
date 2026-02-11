public class TowerOfHanoi {
    private int layer;
    private char source;
    private char temp;
    private char dest;

    public TowerOfHanoi(int layer, char source, char temp, char dest) {
        this.layer = layer;
        this.source = source;
        this.temp = temp;
        this.dest = dest;
    }

    public int getLayer() {
        return this.layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int[] setup(int layer) {
        int[] setup = new int[layer];
        for (int i = 0; i < setup.length; i++) {
            setup[i] = i + 1;
        }
        return setup;
    }

    private int count = 0;

    public void start() {
        hanoi(layer, source, temp, dest);
        System.out.println("Total : " + count + " steps.");
    }

    private void hanoi(int n, char source, char temp, char dest) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from rod " + source + " to rod " + dest);
            count++;
            return;
        }
        hanoi(n - 1, source, dest, temp);
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + dest);
        count++;
        hanoi(n - 1, temp, source, dest);
    }
}
