import java.util.Scanner; //WRONG ANSWER

public class ProblemD {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String[] e = scr.nextLine().split(" ");
        long[] n = new long[e.length];
        String output = "";

        for (int i = 0; i < n.length; i++) {
            n[i] = Long.parseLong(e[i]);
        }

        for (int i = 0; i < n.length; i++) {
            long w = n[i];
            long counter = n[i];

            while (counter > 10) {
                if (counter > 10) {
                    counter /= 10;
                }
            }

            if (counter == 7 || counter == 9) {
                while (w > 10000) {
                    w /= 10000;
                }
                if (w == 7) {
                    output += 'p';
                } else if (w == 77) {
                    output += 'q';
                } else if (w == 777) {
                    output += 'r';
                } else if (w == 7777) {
                    output += 's';
                } else if (w == 9) {
                    output += 'w';
                } else if (w == 99) {
                    output += 'x';
                } else if (w == 999) {
                    output += 'y';
                } else if (w == 9999) {
                    output += 'z';
                }
            } else {
                while (w > 1000) {
                    w /= 1000;
                }
                if (w == 2) {
                    output += 'a';
                } else if (w == 22) {
                    output += 'b';
                } else if (w == 222) {
                    output += 'c';
                } else if (w == 3) {
                    output += 'd';
                } else if (w == 33) {
                    output += 'e';
                } else if (w == 333) {
                    output += 'f';
                } else if (w == 4) {
                    output += 'g';
                } else if (w == 44) {
                    output += 'h';
                } else if (w == 444) {
                    output += 'i';
                } else if (w == 5) {
                    output += 'j';
                } else if (w == 55) {
                    output += 'k';
                } else if (w == 555) {
                    output += 'l';
                } else if (w == 6) {
                    output += 'm';
                } else if (w == 66) {
                    output += 'n';
                } else if (w == 666) {
                    output += 'o';
                } else if (w == 8) {
                    output += 't';
                } else if (w == 88) {
                    output += 'u';
                } else if (w == 888) {
                    output += 'v';
                } else if (w == 0) {
                    output += ' ';
                }
            }

        }
        System.out.println(output);
        scr.close();
    }
}
