import java.util.StringTokenizer;

import pack.MyQueue_680123;
import pack.MyStack_680123;

public class MyShuntingYard_680123 {
    public static void main(String[] args) {
        // Demo
        String inFix = "( 4 + 2 ) / 3 * ( 8 - 5 )";
        String postFix = MyShuntingYard_680123.infixToPostfix(inFix);
        System.out.println("postFix = " + postFix);
        System.out.println("answer = " + MyRPN_680123.computeRPN(postFix));
    }

    public static String infixToPostfix(String infixString) {
        MyQueue_680123<String> output = new MyQueue_680123<>();
        MyStack_680123<String> operator = new MyStack_680123<>();

        StringTokenizer st = new StringTokenizer(infixString);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isNumeric(t)) {
                output.enqueue(t);
            } else if (isOperator(t)) {
                while (!operator.isEmpty() && precedence(operator.peek()) >= precedence(t)) {
                    output.enqueue(operator.pop());
                }
                operator.push(t);
            } else if (t.equals("(")) {
                operator.push(t);
            } else if (t.equals(")")) {
                while (!operator.isEmpty() && !operator.peek().equals("(")) {
                    output.enqueue(operator.pop());
                }
                operator.pop();
            }
        }
        while (!operator.isEmpty()) {
            output.enqueue(operator.pop());
        }
        return output.toString();
    }

    public static boolean isNumeric(String t) {
        try {
            Double.parseDouble(t);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }

    public static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 1;
        } else if (op.equals("*") || op.equals("/")) {
            return 2;
        } else {
            return 0;
        }
    }
}
