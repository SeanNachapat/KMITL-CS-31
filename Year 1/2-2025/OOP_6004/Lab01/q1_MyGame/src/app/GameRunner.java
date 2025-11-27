package q1_MyGame.src.app;

import q1_MyGame.src.model.Hero;

public class GameRunner {
    static void q1_1() {
        // Hero myHero = new Hero();
        // myHero.name = "Archer";
        // myHero.health = 100;
    }

    static void q2_1() {
        Hero myHero = new Hero("Mage");

        System.out.println("Testing negative health:");
        myHero.setHealth(-50);
        System.out.println("Current HP : " + myHero.getHealth());

        System.out.println("\nTesting excessive health:");
        myHero.setHealth(5000);
        System.out.println("Current Hp : " + myHero.getHealth());
    }

    public static void main(String[] args) {
        q2_1();
    }
}
