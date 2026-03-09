class Node {
    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isOperator() {
        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
    }

    public double evaluate(boolean showCalc) {
        if (!isOperator()) {
            return Double.parseDouble(value);
        }

        double leftVal = left.evaluate(showCalc);
        double rightVal = right.evaluate(showCalc);
        double result = 0.0;

        switch (value) {
            case "+":
                result = leftVal + rightVal;
                break;
            case "-":
                result = leftVal - rightVal;
                break;
            case "*":
                result = leftVal * rightVal;
                break;
            case "/":
                result = leftVal / rightVal;
                break;
        }

        if (showCalc) {
            String lStr = (leftVal == Math.floor(leftVal)) ? String.valueOf((long) leftVal) : String.valueOf(leftVal);
            String rStr = (rightVal == Math.floor(rightVal)) ? String.valueOf((long) rightVal)
                    : String.valueOf(rightVal);
            String resStr = (result == Math.floor(result)) ? String.valueOf((long) result) : String.valueOf(result);
            System.out.println(lStr + " " + value + " " + rStr + " = " + resStr);
        }

        return result;
    }
}