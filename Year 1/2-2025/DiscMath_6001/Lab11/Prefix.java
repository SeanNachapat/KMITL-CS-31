import java.util.Stack;

public class Prefix {
    public static Node buildTree(String expr) {
        String[] tokens = expr.trim().split("\\s+");
        Stack<Node> nodes = new Stack<>();
        Stack<String> ops = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                while (!ops.isEmpty() && hasPriority(ops.peek(), token)) {
                    processTop(nodes, ops);
                }
                ops.push(token);
            } else {
                nodes.push(new Node(token));
            }
        }

        while (!ops.isEmpty()) {
            processTop(nodes, ops);
        }

        if (nodes.isEmpty()) {
            return null;
        }

        return nodes.pop();
    }

    public static String buildPrefix(Node node) {
        if (node == null)
            return "";
        if (!node.isOperator()) {
            return node.value;
        }
        return node.value + " " + buildPrefix(node.left) + " " + buildPrefix(node.right);
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int getPriority(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

    private static boolean hasPriority(String op1, String op2) {
        int prec1 = getPriority(op1);
        int prec2 = getPriority(op2);

        if (prec1 == -1 || prec2 == -1) {
            return false;
        }

        return prec1 >= prec2;
    }

    private static void processTop(Stack<Node> nodes, Stack<String> ops) {
        String op = ops.pop();
        if (nodes.size() < 2)
            return;
        Node right = nodes.pop();
        Node left = nodes.pop();
        nodes.push(new Node(op, left, right));
    }
}
