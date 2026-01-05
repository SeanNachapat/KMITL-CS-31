import java.util.Arrays;
import java.util.Scanner;

class TowComp {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int input = 1;
        while (input > 0) {
            input = scr.nextInt();
        }
        System.out.printf("-----Convert %s to Binary-----\n", input);
        int[] bi = convertToBi(Math.abs(input));
        System.out.println(Arrays.toString(bi));

        System.out.printf("-----%s One's Complement-----\n", input);
        for (int i = 0; i < bi.length; i++) {
            if (bi[i] == 0) {
                bi[i] = 1;
            } else {
                bi[i] = 0;
            }
        }
        System.out.println(Arrays.toString(bi));

        System.out.printf("-----%s Two's Complement-----\n", input);
        System.out.printf("%s \s+\n", Arrays.toString(bi));
        System.out.println(Arrays.toString(convertToBi(1)));
        bi = adder(bi, convertToBi(1));
        System.out.println(Arrays.toString(bi));
        scr.close();
    }

    public static int[] convertToBi(int num) {
        int result[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
        if (num == 0) {
            return result;
        }
        int i = 7;
        while (num > 0) {
            int rem = num % 2;

            result[i] = rem;

            num /= 2;
            i--;
        }

        return result;
    }

    public static int[] adder(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int carry = 0;
        for (int i = arr1.length - 1; i >= 0; i--) {
            if (arr1[i] + arr2[i] + carry == 0) {
                result[i] = 0;
                carry = 0;
            } else if (arr1[i] + arr2[i] + carry == 1) {
                result[i] = 1;
                carry = 0;
            } else if (arr1[i] + arr2[i] + carry == 2) {
                result[i] = 0;
                carry = 1;
            } else if (arr1[i] + arr2[i] + carry == 3) {
                result[i] = 1;
                carry = 1;
            }

        }
        return result;
    }
}
