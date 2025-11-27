public class Lab7_680123 {
    public static void main(String[] args) {
        // System.out.println(q2_1_myIndexOf("PMRQNO", "O"));
        // System.out.println(q2_2_containsAndBefore("PMRQNO", "PMO", "ONQ"));
        // System.out.println(q2_3_replaceWith("At KMITL CHALONGKRUNG BMI MTL", "MI",
        // "CSP"));
        System.out.println(q2_4_isClockwiseRoate("KMITL", "OK"));
    }

    static int q2_1_myIndexOf(String str, String sub) {
        for (int i = 0; i < str.length() - sub.length() + 1; i++) {
            int offset = 0;
            while (str.charAt(i + offset) == sub.charAt(offset)) {
                offset++;
                if (offset == sub.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    static boolean q2_2_containsAndBefore(String input, String sub1, String sub2) {
        if (q2_1_myIndexOf(input, sub1) == -1 || q2_1_myIndexOf(input, sub2) == -1) {
            return false;
        }
        return true;
    }

    static String q2_3_replaceWith(String str, String pattern, String newPattern) {

        String output = "";
        for (int i = 0; i < str.length() - pattern.length() + 1; i++) {
            int offset = 0;
            while (str.charAt(i + offset) == pattern.charAt(offset)) {
                offset++;
                if (offset == pattern.length()) {
                    output += newPattern;
                    i += pattern.length();
                    break;
                }
            }
            output += str.charAt(i);
        }
        return output;
    }

    static boolean q2_4_isClockwiseRoate(String str, String pattern) {
        if (q2_1_myIndexOf(str + str, pattern) == -1) {
            return false;
        }
        return true;
    }
}
