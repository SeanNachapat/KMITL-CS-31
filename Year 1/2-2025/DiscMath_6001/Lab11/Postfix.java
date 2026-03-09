public class Postfix {
    public static String buildPostfix(Node node) {
        if (node == null)
            return "";
        if (!node.isOperator()) {
            return node.value;
        }
        return buildPostfix(node.left) + " " + buildPostfix(node.right) + " " + node.value;
    }
}
