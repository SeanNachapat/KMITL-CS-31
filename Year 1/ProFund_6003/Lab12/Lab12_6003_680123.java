class Lab12_6003_680123 {
    static void demo_1_initialize_object() {
        System.out.println("-new and toString()----");
        Person yd = new Person("Yindee", 2000);
        Person pd = new Person("Preeda", 1000);
        yd.introduce_self();
        pd.introduce_self();
        System.out.println(yd);
        System.out.println(pd);
    }

    static void demo_2_interaction_equality() {
        System.out.println("-object interation----");
        Person yd1 = new Person("Yindee", 2000);
        Person pd = new Person("Preeda", 1000);
        System.out.println(yd1.isWealthier(pd));

        Person yd2 = new Person("Yindee", 2000);
        System.out.println("== tests on references' address" + (yd1 == yd2));
        System.out.println(".equals() " + yd1.equals(yd2));
        System.out.println(".equals() " + yd2.equals(yd1));
        System.out.println(".equals() " + yd1.equals(pd));
    }

    static void demo_3_more_interaction() {
        System.out.println("-person's saving change----");
        Person yd = new Person("Yindee", 2000);
        Person pd = new Person("Preeda", 1000);
        yd.reward(pd, 400);
        System.out.println(yd);
        System.out.println(pd);
    }

    static void demo_4() {
        RomanCoin coin2473 = new RomanCoin(2473);
        RomanCoin coin5 = new RomanCoin(5);
        System.out.println(coin2473.getRomanNumeral()); // MMCDLXXIII
        System.out.println(coin2473.getValue()); // 2473
        System.out.println(coin5); // RomanCoin [Value=5, Roman=V]
        System.out.println(coin2473.compareValue(coin5)); // true
        System.out.println(coin5.compareValue(10)); // false
    }

    static void demo_5() {
        RomanCoin coin2473 = new RomanCoin(2473);
        RomanCoin coin5 = new RomanCoin(5);
        coin2473.collide(coin5);
        System.out.println(coin2473); // RomanCoin [Value=2473, Roman=MMCDLXXIII, Face=head ]
        System.out.println(coin5); // RomanCoin [Value=5, Roman=V, Face=tail ]
    }

    static void demo_6() {
        System.out.println(RomanCoin.toRomanNumeric(2019)); // MMCDLXXIII
    }

    public static void main(String[] args) {
        demo_1_initialize_object();
        demo_2_interaction_equality();
        demo_3_more_interaction();
        demo_4();
        demo_5();
        demo_6();
    }
}
