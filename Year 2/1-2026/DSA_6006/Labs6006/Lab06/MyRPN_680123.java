import java.util.StringTokenizer;

import pack.MyQueue_680123;
import pack.MyStack_680123;

public class MyRPN_680123 {
    public static void main(String[] args) {
        String expr = "8 5 - 4 2 + 3 / *";
        System.out.println("Test case:");
        System.out.println("\"" + expr + "\"" + "  ->  " + computeRPN(expr));
    }

    public static double computeRPN(String rpn) {
        MyStack_680123<Double> stack = new MyStack_680123<>();
        StringTokenizer st = new StringTokenizer(rpn);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isNumeric(t)) {
                stack.push(Double.parseDouble(t));
            } else {
                Double b = stack.pop();
                Double a = stack.pop();
                if (t.equals("+")) {
                    stack.push(a + b);
                } else if (t.equals("-")) {
                    stack.push(a - b);
                } else if (t.equals("*")) {
                    stack.push(a * b);
                } else {
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }

    public static boolean isNumeric(String t){
        try {
            Double.parseDouble(t);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
