import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set set = new Set();

        System.out.print("Set: ");
        String setLine = scanner.nextLine();
        Scanner setScanner = new Scanner(setLine);
        while (setScanner.hasNextInt()) {
            set.add(setScanner.nextInt());
        }
        setScanner.close();

        if (set.getElements().isEmpty()) {
            scanner.close();
            return;
        }

        System.out.println("Set: " + set.getElements());

        Relation relation = new Relation(set);

        System.out.print("Relation: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int numPairs = scanner.nextInt();

        for (int i = 0; i < numPairs; i++) {
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            int x = scanner.nextInt();
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            int y = scanner.nextInt();

            relation.addPair(x, y);
        }

        relation.checkAll();

        scanner.close();
    }
}


