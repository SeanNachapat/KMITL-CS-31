class RomanCoin {
    private int value;
    private String romanNumeral = intToRoman(value);
    private boolean face;

    private String intToRoman(int num) {
        if (num < 1 || num > 3999)
            return "Value Out of Range";
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",
                "IV", "I" };
        StringBuilder roman = new StringBuilder();
        int tempNum = num; // Use a temporary variable to modify
        for (int i = 0; i < values.length; i++) {
            while (tempNum >= values[i]) {
                roman.append(symbols[i]);
                tempNum -= values[i];
            }
        }
        return roman.toString();
    }

    public RomanCoin(int val) {
        this.value = val;
        this.romanNumeral = intToRoman(val);
        face = true;
    }

    public int getValue() {
        return value;
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }

    @Override
    public String toString() {
        return getClass().getName() + " [Value=" + value + ", Roman=" + romanNumeral + ", Face="
                + (face == true ? "head" : "tail") + "]";
    }

    public boolean compareValue(RomanCoin otherCoin) {
        return this.value > otherCoin.value;
    }

    public boolean compareValue(int num) {
        return this.value > num;
    }

    static String toRomanNumeric(int d) {
        if (d < 1 || d > 3999) {
            return "Invalid Value: " + d;
        }
        StringBuilder symbol = new StringBuilder();
        int val = d; // Use a mutable copy of the input value
        // Thousands (M)
        while (val >= 1000) {
            symbol.append("M");
            val -= 1000;
        }
        /* your code */
        if (val >= 900) {
            symbol.append("CM");
            val -= 900;
        }
        if (val >= 500) {
            symbol.append("D");
            val -= 500;
        }
        if (val >= 400) {
            symbol.append("CD");
            val -= 400;
        }
        while (val >= 100) {
            symbol.append("C");
            val -= 100;
        }
        if (val >= 90) {
            symbol.append("XC");
            val -= 90;
        }
        if (val >= 50) {
            symbol.append("L");
            val -= 50;
        }
        if (val >= 40) {
            symbol.append("XL");
            val -= 40;
        }
        while (val >= 10) {
            symbol.append("X");
            val -= 10;
        }
        // Nine (IX)
        if (val >= 9) {
            symbol.append("IX");
            val -= 9;
        }
        // Fives (V)
        while (val >= 5) {
            symbol.append("V");
            val -= 5;
        }
        // Four (IV)
        if (val >= 4) {
            symbol.append("IV");
            val -= 4;
        }
        // Ones (I)
        while (val >= 1) {
            symbol.append("I");
            val -= 1;
        }
        return symbol.toString();
    }

    public void collide(RomanCoin theOther) {
        theOther.face = theOther.face == true ? false : true;
    }
}
