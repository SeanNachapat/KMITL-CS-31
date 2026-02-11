public class Main {
    public static void main(String[] args) {
        TowerOfHanoi t1 = new TowerOfHanoi(1, 'A', 'B', 'C');
        TowerOfHanoi t2 = new TowerOfHanoi(3, 'A', 'B', 'C');
        TowerOfHanoi t3 = new TowerOfHanoi(4, 'A', 'B', 'C');

        t1.start();
        System.out.println("========================");
        t2.start();
        System.out.println("========================");
        t3.start();
    }
}
