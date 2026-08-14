import java.util.Stack;

class Lab05a_681023 {
    public static void main(String[] args) {
        Demo1();
        Demo2();
    }

    public static String removeDuplicates(String s) {
        Stack<Character> ch = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!ch.isEmpty() && ch.peek().equals(c)) {
                ch.pop();
            } else {
                ch.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!ch.isEmpty()) {
            result.append(ch.removeLast());
        }
        return result.toString();
    }

    public static void Demo1(){
        System.out.println(removeDuplicates("abbaca"));
    }

    public static void Demo2(){
        System.out.println(removeDuplicates("azxxzy"));
    }
}