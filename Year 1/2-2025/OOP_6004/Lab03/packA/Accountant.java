package packA;

public class Accountant extends EmpTmp {
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;

    public Accountant(String name, int superExp, int experience, int sal, String talent) {
        super(name, superExp, sal);
        this.experience = experience;
        this.specialty = talent;
    }

    public void setSpecialty(String newSpecialty) {
        this.specialty = newSpecialty;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setAccountantExperience(int exp) {
        this.experience = exp;
    }

    public int getAccountantExperience() {
        return this.experience;
    }

    public String tellProfit() {
        return companyName + "'s profit is " + (int) (Math.random() * 1000) + ". My salary is " + this.getSalary();
    }

    @Override
    public String toString() {
        return "Accountant [name=" + name + ", company=" + companyName + "]";
    }

    public void sayHi() {
        System.out.println(name + ", an accountant, say hello");
    }

    public static String tellMyRole() {
        return "I am an accountant at " + companyName;
    }
}
