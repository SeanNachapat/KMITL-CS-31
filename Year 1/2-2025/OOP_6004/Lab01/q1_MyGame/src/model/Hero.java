package q1_MyGame.src.model;

public class Hero {
    private String name;
    private int health;

    public Hero(String name) {
        this.name = name;
        this.health = 100;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int newHealth) {
        if (newHealth < 0) {
            System.out.println("Error: Health cannot be negative. Setting to 0.");
            this.health = 0;
        } else if (newHealth > 100) {
            System.out.println("Error: Health cannot exceed 100. Setting to 100.");
            this.health = 100;
        } else {
            this.health = newHealth;
        }
    }

    public String getname() {
        return this.name;
    }

    public void intruduce() {
        System.out.println("I am " + name + " with HP: " + health);
    }
}