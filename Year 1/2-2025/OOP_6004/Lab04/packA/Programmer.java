package packA;

import java.util.ArrayList;

public class Programmer extends Employee {
    protected ArrayList<String> skills = new ArrayList<>();

    public Programmer(String n, int exp, int sal) {
        super(n, exp, sal);
    }

    @Override
    public void sayHi() {
        System.out.println("hi from " + name);
    }

    public String toString() {
        return "Programmer [name=" + name + ", salary=" + salary + "]";
    }

    public String coding() {
        return "I am coding.";
    }

    public ArrayList<String> getSkills() {
        return skills;
    }
}