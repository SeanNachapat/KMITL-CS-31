import java.util.Scanner;

public class Menu {
    public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix : ");
        String expr = sc.nextLine();

        Node root = Prefix.buildTree(expr);
        if (root == null) {
            System.out.println("Invalid.");
            sc.close();
            return;
        }

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1 - Prefix");
            System.out.println("2 - Infix");
            System.out.println("3 - Postfix");
            System.out.println("4 - Answer");
            System.out.println("5 - Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Prefix: " + Prefix.buildPrefix(root));
                    break;
                case "2":
                    System.out.println("Infix: " + Infix.buildInfix(root));
                    break;
                case "3":
                    System.out.println("Postfix: " + Postfix.buildPostfix(root));
                    break;
                case "4":
                    System.out.println("Answer:");
                    double result = root.evaluate(true);
                    String resStr = (result == Math.floor(result)) ? String.valueOf((long) result)
                            : String.valueOf(result);
                    System.out.println("Final Result: " + resStr);
                    break;
                case "5":
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid. Please try again.");
            }
        }
    }
}
