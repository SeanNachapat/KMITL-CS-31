public class Infix {
    public static String buildInfix(Node node) {
        if (node == null)
            return "";
        if (!node.isOperator()) {
            return node.value;
        }
        return "(" + buildInfix(node.left) + " " + node.value + " " + buildInfix(node.right) + ")";
    }
}
